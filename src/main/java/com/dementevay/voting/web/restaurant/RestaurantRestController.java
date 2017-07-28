package com.dementevay.voting.web.restaurant;

import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.service.MealService;
import com.dementevay.voting.service.RestaurantService;
import com.dementevay.voting.to.RestaurantWithMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 27.07.17.
 */
@RestController
@RequestMapping(RestaurantRestController.REST_URL)
public class RestaurantRestController extends AbstractController {
    static final String REST_URL = "/rest/restaurants";

    public RestaurantRestController(RestaurantService restaurantService, MealService serviceMeal) {
        super(restaurantService, serviceMeal);
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
    @GetMapping("getall")
    public List<RestaurantWithMenu> getAllRestaurantWithMenuByDay(LocalDateTime dateTime) {
        return super.getAllRestaurantWithMenuByDay(dateTime);
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
