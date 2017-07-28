package com.dementevay.voting.to;

import com.dementevay.voting.model.Meal;
import com.dementevay.voting.model.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrey Dementev on 25.07.17.
 */
public class RestaurantWithMenu {
    private int id;
    private String name;
    private List<Meal> menu;

    public RestaurantWithMenu(Restaurant restaurant, List<Meal> menu) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.menu = menu;
    }

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    /*public void setName(String name) {
        this.name = name;
    }*/

    public List<Meal> getMenu() {
        return menu;
    }

    /*public void setMenu(List<Meal> menu) {
        this.menu = menu;
    }*/
}

