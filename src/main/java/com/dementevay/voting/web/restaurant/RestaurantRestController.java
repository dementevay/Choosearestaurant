package com.dementevay.voting.web.restaurant;

import com.dementevay.voting.service.meal.MealService;
import com.dementevay.voting.service.restaurants.RestaurantService;
import com.dementevay.voting.to.RestaurantWithMenu;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 27.07.17.
 */

@RestController
@RequestMapping(value = RestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantRestController extends RestaurantAbstractController {
    public static final String REST_URL = "/rest/restaurants";

    public RestaurantRestController(RestaurantService restaurantService, MealService serviceMeal) {
        super(restaurantService, serviceMeal);
    }

    @Override//   /rest/restaurants/100005
    @GetMapping(value = "/{id}")
    public RestaurantWithMenu get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @GetMapping(value = "/{id}/{date}")
    public RestaurantWithMenu getForDate(
            @PathVariable("id") int id,
            @PathVariable(value = "date", required = false) LocalDateTime dateTime) {
        return super.getForDate(id, dateTime);
    }

    @Override
    @GetMapping(value = "/")
    public List<RestaurantWithMenu> getAll() {
        return super.getAll();
    }

    @Override//   /{"2017-07-26T10:00:00"}
    @GetMapping(value = "/date/{date}")
    public List<RestaurantWithMenu> getAllByDate(@PathVariable("date") LocalDateTime dateTime) {
        return super.getAllByDate(dateTime);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody RestaurantWithMenu restaurant) {
        super.save(restaurant);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody RestaurantWithMenu restaurant) {
        super.save(restaurant);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @Override
    @DeleteMapping(value = "/")
    public void deleteAll() {
        super.deleteAll();
    }
}
