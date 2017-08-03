package com.dementevay.voting.service;

import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Andrey Dementev on 25.07.17.
 */

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restaurant get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    @Override
    public int save(Restaurant restaurant, int userId) {
        repository.save(restaurant, userId);
        return restaurant.getId();
    }

    @Override
    public void delete(int id, int userId) {
        repository.delete(id, userId);
    }

    @Override
    public void deleteAll(int userId) {
        repository.deleteAll(userId);
    }
}
