package com.dementevay.voting.repository.restaurant;

import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.to.RestaurantWithMenu;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Andrey Dementev on 25.07.17.
 */
public interface RestaurantRepository {

    Restaurant get(int id);

    void delete(int id, int user_id) ;

    void deleteAll(int userId);

    List<Restaurant> getAll() ;

    void save(Restaurant restaurant, int user_id);

}
