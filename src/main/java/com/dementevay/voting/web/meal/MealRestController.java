package com.dementevay.voting.web.meal;

import com.dementevay.voting.model.Meal;
import com.dementevay.voting.service.meal.MealService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Andrey Dementev on 27.07.17.
 */
@RestController
@RequestMapping(value = MealRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MealRestController extends AbstractMealController {
    public static final String REST_URL = "/rest/meals";

    public MealRestController(MealService serviceMeal) {
        super(serviceMeal);
    }

    @Override
    @GetMapping(value = "/{id}")
    public Meal get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @GetMapping(value = "/restaurant/{restaurantId}")
    public List<Meal> getForRestaurant(@PathVariable("restaurantId") int restaurantId) {
        return super.getForRestaurant(restaurantId);
    }

    @Override
    @GetMapping(value = "/restaurant/{restaurantId}/{date}")
    public List<Meal> getForRestaurantByDay(
            @PathVariable("restaurantId") int restaurantId,
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
        return super.getForRestaurantByDay(restaurantId, localDate);
    }

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Meal meal) {
        super.save(meal);
    }

    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Meal meal) {
        super.save(meal);
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

    @Override
    @DeleteMapping(value = "/date/{date}")
    public void deleteAllByDate(
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
        super.deleteAllByDate(localDate);
    }

    @DeleteMapping(value = "/restaurant/{restaurantId}")
    public void deleteByRestaurant(@PathVariable("restaurantId") int restaurantId) {
        super.deleteByRestaurant(restaurantId);
    }

    @DeleteMapping(value = "/restaurant/{restaurantId}/{date}")
    public void deleteByRestaurantAndDay(
            @PathVariable("restaurantId") int restaurantId,
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate ) {
        super.deleteByRestaurantAndDay(restaurantId, localDate);
    }
}
