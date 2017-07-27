package com.dementevay.voting.web;

import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.service.RestaurantService;
import com.dementevay.voting.to.RestaurantWithMenu;
import com.dementevay.voting.web.restaurant.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 26.07.17.
 */
@Controller
public class RootController extends AbstractController{

    @Autowired
    public RootController(RestaurantService restaurantService) {super(restaurantService);}

    @GetMapping("/")
    public String root() {
//        LocalDateTime ldt = LocalDateTime.MAX;
//        getAll(ldt);
        return "vote";
    }

    @Override
    public RestaurantWithMenu get(int id, LocalDateTime dateTime) {
        return super.get(id, dateTime);
    }

    @Override
    public void delete(int id, int user_id) {
        super.delete(id, user_id);
    }

    @Override
    public List<RestaurantWithMenu> getAll(LocalDateTime dateTime) {
        return super.getAll(dateTime);
    }

    @Override
    public RestaurantWithMenu create(String name, String menu, int user_id) {
        return super.create(name, menu, user_id);
    }

    @Override
    public void update(int id, String name, String menu, int user_id) {
        super.update(id, name, menu, user_id);
    }
}
