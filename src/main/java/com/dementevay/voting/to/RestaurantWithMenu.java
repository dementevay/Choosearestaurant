package com.dementevay.voting.to;

import com.dementevay.voting.HasId;
import com.dementevay.voting.model.Meal;
import com.dementevay.voting.model.Restaurant;

import java.util.List;

/**
 * Created by Andrey Dementev on 25.07.17.
 */
public class RestaurantWithMenu implements HasId{
    private Integer id;
    private String name;
    private List<Meal> menu;

    public RestaurantWithMenu(Restaurant restaurant, List<Meal> menu) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.menu = menu;
    }

    public RestaurantWithMenu(int id, String name, List<Meal> menu) {
        this.id = id;
        this.name = name;
        this.menu = menu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<Meal> getMenu() {
        return menu;
    }

    public boolean menuIsEmpty(){
        return menu.isEmpty();
    }

}

