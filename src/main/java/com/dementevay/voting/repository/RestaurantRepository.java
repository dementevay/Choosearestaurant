package com.dementevay.voting.repository;

import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.to.RestaurantWithMenu;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 25.07.17.
 */
public interface RestaurantRepository {

    public RestaurantWithMenu get(int id, LocalDateTime dateTime);

    public void delete(int id, int user_id) ;

    public List<RestaurantWithMenu> getAll(LocalDateTime dateTime) ;

    public RestaurantWithMenu create(String name, String menu, int user_id) ;

    public void update(int id, String name, String menu, int user_id) ;

    public List<Restaurant> getSS();

}
