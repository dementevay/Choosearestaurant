package com.dementevay.voting.repository.meal;

import com.dementevay.voting.model.Meal;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Andrey Dementev on 27.07.17.
 */
public interface MealRepository {

    Meal get(int id);

    List<Meal> getForRestaurantByDay(int restaurant_id, LocalDate localDate);

    List<Meal> getForRestaurant(int restaurant_id);

    void delete(int id, int userId) ;

    void deleteAll(int userId) ;

    void deleteAllByDate(LocalDate localDate, int userId) ;

    void deleteByRestaurant (int restaurantId, int userId);

    void deleteByRestaurantAndDay (int restaurantId, LocalDate localDate, int userId);

    List<Meal> getAll() ;

    void save(Meal meal, int userId);
}
