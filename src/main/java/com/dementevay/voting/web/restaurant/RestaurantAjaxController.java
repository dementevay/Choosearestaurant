package com.dementevay.voting.web.restaurant;

import com.dementevay.voting.AuthorizedUser;
import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.service.meal.MealService;
import com.dementevay.voting.service.restaurants.RestaurantService;
import com.dementevay.voting.to.RestaurantWithMenu;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import static com.dementevay.voting.DateTimeForTests.*;

/**
 * Created by Andrey Dementev on 05.10.17.
 */
@RestController
@RequestMapping(value = "/ajax/restaurants")
public class RestaurantAjaxController extends RestaurantAbstractController {
    public RestaurantAjaxController(RestaurantService restaurantService, MealService serviceMeal) {
        super(restaurantService, serviceMeal);
    }

    @Override
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
//    @JsonView(RestaurantWithMenu.class)
    public List<RestaurantWithMenu> getAll() {
        return super.getAllByDate(localDate);
    }

    @Override
    @GetMapping(value = "/{id}")
//    @JsonView(RestaurantWithMenu.class)
    public RestaurantWithMenu get(@PathVariable("id") int id) {
        return id != 0 ? super.get(id):new RestaurantWithMenu(id, "", new ArrayList<>());
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
//    @JsonView(Restaurant.class)
    public void saveRestaurant(Restaurant restaurant) {
        serviceRestaurant.save(restaurant, AuthorizedUser.id());
    }

    @PostMapping(value = "/reset")
//    @JsonView(Restaurant.class)
    public void reset () {
        serviceRestaurant.ResetDatabase();
    }
}
