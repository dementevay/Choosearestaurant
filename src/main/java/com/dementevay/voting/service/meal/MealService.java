package com.dementevay.voting.service.meal;

import com.dementevay.voting.model.Meal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 27.07.17.
 */
public interface MealService {

    Meal get(int id);

    List<Meal> getForRestaurantByDay(int restaurant_id, LocalDate localDate);

    List<Meal> getForRestaurant(int restaurant_id);

    void delete(int id, int user_id);

    List<Meal> getAll();

    void save(Meal meal, int user_id);

    Meal create(String name, String menu, int user_id);
}
