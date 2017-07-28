package com.dementevay.voting.service;

import com.dementevay.voting.model.Restaurant;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 25.07.17.
 */
public interface RestaurantService {
    public Restaurant get(int id);

    public void delete(int id, int user_id) ;

    public List<Restaurant> getAll() ;

    public Restaurant create(String name, String menu, int user_id) ;

    public void update(int id, String name, String menu, int user_id) ;

    public List<Restaurant> getSS();
}
