package com.dementevay.voting.service;

import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.repository.RestaurantRepository;
import com.dementevay.voting.to.RestaurantWithMenu;
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

    public RestaurantWithMenu get(int id, LocalDateTime dateTime) {
        return repository.get(id, dateTime);
    }

    public void delete(int id, int user_id) {
        repository.delete(id, user_id);
    }

    public List<RestaurantWithMenu> getAll(LocalDateTime dateTime) {
        return repository.getAll(dateTime);
    }

    public List<Restaurant> getSS() {
        return repository.getSS();
    }

    public RestaurantWithMenu create(String name, String menu, int user_id) {
        return repository.create(name, menu, user_id);
    }

    public void update(int id, String name, String menu, int user_id) {
        repository.update(id, name, menu, user_id);
    }
}
