package com.dementevay.voting.web;

import com.dementevay.voting.model.Meal;
import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.service.MealService;
import com.dementevay.voting.service.RestaurantService;
import com.dementevay.voting.to.RestaurantWithMenu;
import com.dementevay.voting.util.TimeUtil;
import com.dementevay.voting.web.restaurant.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 26.07.17.
 */
@Controller
public class RootController extends AbstractController{

    @Autowired
    public RootController(RestaurantService restaurantService, MealService serviceMeal) {super(restaurantService,serviceMeal);}

    @GetMapping("/")
    public String root(Model model) {
        LocalDateTime dateTime = TimeUtil.stringToLocalDateTime("2017-07-26 10:00:00");
        List<RestaurantWithMenu> list = getAllRestaurantWithMenuByDay(dateTime);
        model.addAttribute("restaurants_list", list);//getAll(TimeUtil.stringToLocalDateTime("2017-07-26 10:00:00")
        return "vote";
    }

    @Override
    public Restaurant get(int id) {
        return super.get(id);
    }

    @Override
    public void delete(int id, int user_id) {
        super.delete(id, user_id);
    }


    @Override
    public Restaurant create(String name, String menu, int user_id) {
        return super.create(name, menu, user_id);
    }

    @Override
    public void update(int id, String name, String menu, int user_id) {
        super.update(id, name, menu, user_id);
    }
}
