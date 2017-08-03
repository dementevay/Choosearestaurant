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
    public List<Meal> getForRestaurant(int restaurant_id) {
        return repository.getForRestaurant(restaurant_id);
    }

    @Override
    public void delete(int id, int userId) {

    }

    @Override
    public List<Meal> getAll() {
        return null;
    }

    @Override
    public void save(Meal meal, int userId) {
        repository.save(meal, userId);
    }

    @Override
    public Meal create(String name, String menu, int userId) {
        return null;
    }

    @Override
    public void update(int id, String name, String menu, int userId) {

    }
}
