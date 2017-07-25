package com.dementevay.voting.to;

import com.dementevay.voting.model.Restaurant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrey Dementev on 25.07.17.
 */
public class RestaurantWithMenu {
    public int id;
    public String name;
    public Map<String, Integer> menu;

    public RestaurantWithMenu (Restaurant restaurant, Map<String, Integer> menu) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.menu = new HashMap<>(menu);
    }
}

