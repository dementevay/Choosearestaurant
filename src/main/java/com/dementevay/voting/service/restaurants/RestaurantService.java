package com.dementevay.voting.service.restaurants;

import com.dementevay.voting.model.Restaurant;

import java.util.List;

/**
 * Created by Andrey Dementev on 25.07.17.
 */
public interface RestaurantService {
    Restaurant get(int id);

    List<Restaurant> getAll();

    int save(Restaurant restaurant, int userId);

    void delete(int id, int userId);

    void deleteAll(int userId);

    void ResetDatabase();
}
