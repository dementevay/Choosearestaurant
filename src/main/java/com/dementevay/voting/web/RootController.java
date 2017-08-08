package com.dementevay.voting.web;

import com.dementevay.voting.AuthorizedUser;
import com.dementevay.voting.DateTimeForTests;
import com.dementevay.voting.model.BaseEntity;
import com.dementevay.voting.service.meal.MealService;
import com.dementevay.voting.service.restaurants.RestaurantService;
import com.dementevay.voting.to.RestaurantWithMenu;
import com.dementevay.voting.web.restaurant.RestaurantAbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 26.07.17.
 */
@Controller
public class RootController extends RestaurantAbstractController {

    @Autowired
    public RootController(RestaurantService restaurantService, MealService serviceMeal) {super(restaurantService,serviceMeal);}

    @GetMapping("/")
    public String root(HttpServletRequest request, Model model) {
        String str = request.getParameter("dateTime");
        LocalDateTime dateTime = str != null ?
                LocalDateTime.parse(str) :
                LocalDateTime.parse("2017-07-26T10:00:00");//hardcode for test data
        List<RestaurantWithMenu> list = getAllByDate(dateTime);
        model.addAttribute("restaurants_list", list);//getAll(TimeUtil.stringToLocalDateTime("2017-07-26 10:00:00")
        return "vote";
    }

    @PostMapping("vote")
    public void postRequest(HttpServletRequest request, Model model) {
        int id = Integer.valueOf(request.getParameter("user_id"));
        AuthorizedUser.setId(id > 0 ? id:BaseEntity.START_SEQ);
        root(request, model);
    }

    @Override
    public RestaurantWithMenu get(int id) {
        return super.get(id);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @GetMapping(value = "/setdatetime/{datetime}")
    public void setDateTime(@PathVariable("datetime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime){
        DateTimeForTests.setDateTime(localDateTime);
    }

    /*@Override
    public Restaurant create(String name, String menu, int userId) {
        return super.create(name, menu, userId);
    }

    @Override
    public void update(int id, String name, String menu, int userId) {
        super.update(id, name, menu, userId);
    }*/
}
