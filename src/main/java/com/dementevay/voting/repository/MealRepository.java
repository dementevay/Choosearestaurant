package com.dementevay.voting.repository;

import com.dementevay.voting.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 27.07.17.
 */
public interface MealRepository {

    public Meal get(int id);

    public List<Meal> getForRestaurantByDay(int restaurant_id, LocalDateTime dateTime);

    public List<Meal> getForRestaurant(int restaurant_id);

    public void delete(int id, int user_id) ;

    public List<Meal> getAll() ;

    void save(Meal meal, int user_id);

    public Meal create(String name, String menu, int user_id) ;

    public void update(int id, String name, String menu, int user_id) ;

}
