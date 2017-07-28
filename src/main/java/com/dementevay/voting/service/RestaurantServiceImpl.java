package com.dementevay.voting.service;

import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Restaurant get(int id) {
        return repository.get(id);
    }

    public void delete(int id, int user_id) {
        repository.delete(id, user_id);
    }

    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    public List<Restaurant> getSS() {
        return repository.getSS();
    }

    public Restaurant create(String name, String menu, int user_id) {
        return repository.create(name, menu, user_id);
    }

    public void update(int id, String name, String menu, int user_id) {
        repository.update(id, name, menu, user_id);
    }
}
