package com.dementevay.voting.web.restaurant;

import com.dementevay.voting.model.Meal;
import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.service.MealService;
import com.dementevay.voting.service.RestaurantService;
import com.dementevay.voting.to.RestaurantWithMenu;
import com.dementevay.voting.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey Dementev on 25.07.17.
 */
public abstract class AbstractController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final RestaurantService service;
    protected final MealService serviceMeal;

    public AbstractController(RestaurantService restaurantService, MealService serviceMeal) {
        this.service = restaurantService;
        this.serviceMeal = serviceMeal;
    }

    public Restaurant get(int id) {
        LOG.info("get Restaurant {} for Date {}", id);
        return null;
    }

    public void delete(int id, int user_id) {
        LOG.info("delete Restaurant {}", id);
        service.delete(id, user_id);
    }

    public List<RestaurantWithMenu> getAllRestaurantWithMenuByDay(LocalDateTime dateTime) {
        LOG.info("get all Restaurant");
        List<Restaurant> listR = service.getAll();
        List<RestaurantWithMenu> restaurantsWithMenu = new ArrayList<>();

        for (Restaurant r: listR) {
            List<Meal> menu = serviceMeal.getForRestaurantByDay(r.getId(), dateTime);
            RestaurantWithMenu rm = new RestaurantWithMenu(r, menu);
            restaurantsWithMenu.add(rm);
        }
        return restaurantsWithMenu;
    }

    /*public List<Restaurant> getAllR () {
        List<Restaurant> rests = service.getSS();
        return rests;
    }*/

    public Restaurant create(String name, String menu, int user_id) {
        LOG.info("create Restaurant {}", name, user_id);
        return service.create(name, menu, user_id);
    }

    public void update(int id, String name, String menu, int user_id) {
        LOG.info("update Restaurant {}", name);
        service.update(id, name, menu, user_id);
    }
}
