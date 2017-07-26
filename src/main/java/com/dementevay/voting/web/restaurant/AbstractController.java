package com.dementevay.voting.web.restaurant;

import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.service.RestaurantService;
import com.dementevay.voting.to.RestaurantWithMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 25.07.17.
 */
@Controller
public abstract class AbstractController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final RestaurantService service;

    @Autowired
    public AbstractController(RestaurantService restaurantService) {
        this.service = restaurantService;
    }

    public RestaurantWithMenu get(int id, LocalDateTime dateTime) {
        LOG.info("get Restaurant {} for Date {}", id, dateTime);
        return null;
    }

    public void delete(int id, int user_id) {
        LOG.info("delete Restaurant {}", id);
        service.delete(id, user_id);
    }

    @RequestMapping(value = "/vote", method = RequestMethod.GET)
    public List<RestaurantWithMenu> getAll(LocalDateTime dateTime) {
        LOG.info("get all Restaurant for Date {}", dateTime);
        return service.getAll(dateTime);
    }

    public RestaurantWithMenu create(String name, String menu, int user_id) {
        LOG.info("create Restaurant {}", name, user_id);
        return service.create(name, menu, user_id);
    }

    public void update(int id, String name, String menu, int user_id) {
        LOG.info("update Restaurant {}", name);
        service.update(id, name, menu, user_id);
    }
}
