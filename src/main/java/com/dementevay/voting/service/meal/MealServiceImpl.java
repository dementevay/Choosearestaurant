package com.dementevay.voting.service.meal;

import com.dementevay.voting.model.Meal;
import com.dementevay.voting.repository.meal.MealRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public List<Meal> getForRestaurantByDay(int restaurantId, LocalDate localDate) {
        return repository.getForRestaurantByDay(restaurantId, localDate);
    }

    @Override
    public List<Meal> getForRestaurant(int restaurantId) {
        return repository.getForRestaurant(restaurantId);
    }

    @Override
    public void delete(int id, int userId) {
        repository.delete(id, userId);
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

}
