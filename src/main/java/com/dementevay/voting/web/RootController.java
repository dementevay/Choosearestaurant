package com.dementevay.voting.web;

import com.dementevay.voting.AuthorizedUser;
import com.dementevay.voting.DateTimeForTests;
import com.dementevay.voting.model.Meal;
import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.model.Vote;
import com.dementevay.voting.service.meal.MealService;
import com.dementevay.voting.service.restaurants.RestaurantService;
import com.dementevay.voting.to.RestaurantWithMenu;
import com.dementevay.voting.util.AuthenticatedUser;
import com.dementevay.voting.web.restaurant.RestaurantAbstractController;
import com.dementevay.voting.web.vote.AbstractVoteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrey Dementev on 26.07.17.
 */
@Controller
public class RootController extends RestaurantAbstractController {

    private final AbstractVoteController voteController;

    @Autowired
    public RootController(RestaurantService restaurantService, MealService serviceMeal, AbstractVoteController voteController) {
        super(restaurantService, serviceMeal);
        this.voteController = voteController;
    }

    @GetMapping("/")
    public String root(HttpServletRequest request, Model model) {
        if (!model.containsAttribute("authenticated_user")) {
            model.addAttribute("authenticated_user", AuthenticatedUser.getName(AuthorizedUser.id()));
        }

        if (!model.containsAttribute("dateTime")) {
            model.addAttribute("dateTime", DateTimeForTests.localDateTime);
        }

        List<RestaurantWithMenu> list = getAllByDate(DateTimeForTests.localDateTime);
        model.addAttribute("restaurants_list", list);

        Vote vote = voteController.getByUserId(AuthorizedUser.id());
        model.addAttribute("user_vote", vote);

        request.setAttribute("winner", voteController.getStringWinnerOnDay(DateTimeForTests.localDate, DateTimeForTests.localTime));
        return "vote";
    }

    @PostMapping("/")
    public String postRequest(HttpServletRequest request, Model model) {
        try {
            if (!request.getParameter("user_id").isEmpty()) {
                int id = Integer.valueOf(request.getParameter("user_id"));
                AuthorizedUser.setId(id);
                model.addAttribute("authenticated_user", AuthenticatedUser.getName(id));
            }
        } catch (Exception e) {
        }

        try {
            if (!request.getParameter("dateTime").isEmpty()) {
                LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"));
                setDateTime(dateTime);
                model.addAttribute("dateTime", dateTime);
            }
        } catch (Exception e) {
        }

        root(request, model);
        return "redirect:/";
    }

    @GetMapping("/vote")
    public String setVote(@RequestParam(value = "restaurant_id") int restaurant_id) {
        Vote vote = new Vote(null, DateTimeForTests.localDate, AuthorizedUser.id(), restaurant_id);
        voteController.save(vote);
        return "redirect:/";
    }

    @GetMapping("/editRestaurant")
    public String saveRestaurant(@RequestParam(value = "id") int id, Model model) {
        if (id != 0) {
            model.addAttribute("restaurant", super.getForDate(id, DateTimeForTests.localDateTime));
        } else {
            model.addAttribute("restaurant",
                    new RestaurantWithMenu(id, "",
                            Arrays.asList(new Meal(id, 0, "", 0, DateTimeForTests.localDate))));
        }
        return "restaurant";
    }

    @PostMapping("/saveRestaurant")
    public String saveRestaurantPost(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "name") String name,
            Model model) {
        Restaurant restaurant = new Restaurant(id, name);
        id = super.serviceRestaurant.save(restaurant, AuthorizedUser.id());

        model.addAttribute("restaurant", super.get(id));
        return "restaurant";
    }

    @PostMapping("/editMeal")
    public String editMeal(@RequestParam(value = "id") int id,
                           @RequestParam(value = "restaurant_id") int restaurant_id,
                           @RequestParam(value = "dateTime") LocalDate dateTime,
                           @RequestParam(value = "description") String description,
                           @RequestParam(value = "price") int price,
                           Model model) {

        try {
            Meal meal = new Meal(id, restaurant_id, description, price, dateTime);
            super.serviceMeal.save(meal,AuthorizedUser.id());
        } catch (Exception e) {
            if (restaurant_id == 0) {
                super.LOG.info("RESTAURANT NOT EXIST, food should belong to a restaurant.");
            }
        }

        model.addAttribute("restaurant", super.get(restaurant_id));
        return "restaurant";
    }

    @GetMapping("newMeal")
    public String newMeal (@RequestParam(value = "restaurant_id") int restaurant_id,
                           Model model){
        Meal meal = new Meal(0,restaurant_id, "", 0, DateTimeForTests.localDate );
        model.addAttribute("meal", meal);
        return "meal";
    }

    @GetMapping("delete_meal")
    public String deleteMeal (@RequestParam(value = "id") int id,
                              @RequestParam(value = "restaurant_id") int restaurant_id,
                              Model model){
        super.serviceMeal.delete(id, AuthorizedUser.id());

        model.addAttribute("restaurant", super.get(restaurant_id));
        return "restaurant";
    }

    @GetMapping("delete")
    public String deleteRestaurant(@RequestParam(value = "id") int id,
                                   HttpServletRequest request, Model model) {
        super.delete(id);
        return "redirect:/";
    }

    @GetMapping(value = "/setdatetime/{datetime}")
    public void setDateTime(@PathVariable("datetime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime) {
        DateTimeForTests.setDateTime(localDateTime);
    }

}
