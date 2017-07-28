package com.dementevay.voting.service;

import com.dementevay.voting.model.Meal;
import com.dementevay.voting.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 27.07.17.
 */
@Service
public class MealServiceImpl implements MealService{

    private final MealRepository repository;

    public MealServiceImpl(MealRepository repository) {
        this.repository = repository;
    }

    @Override
    public Meal get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Meal> getForRestaurantByDay(int restaurant_id, LocalDateTime dateTime) {
        return repository.getForRestaurantByDay(restaurant_id, dateTime);
    }

    @Override
    public Meal getForRestaurant(int restaurant_id) {
        return null;
    }

    @Override
    public void delete(int id, int user_id) {

    }

    @Override
    public List<Meal> getAll() {
        return null;
    }

    @Override
    public Meal create(String name, String menu, int user_id) {
        return null;
    }

    @Override
    public void update(int id, String name, String menu, int user_id) {

    }
}
