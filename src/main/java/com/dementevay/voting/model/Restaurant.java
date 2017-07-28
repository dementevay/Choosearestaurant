package com.dementevay.voting.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
@NamedQueries({
        @NamedQuery(name = Restaurant.GET_ID, query = "SELECT r FROM Restaurant r WHERE r.id = :id"),
        @NamedQuery(name = Restaurant.GET_ALL, query = "SELECT r FROM Restaurant r")
})


@Entity
@Table(name = "restaurants")
public class Restaurant extends NamedEntity {
    public static final String GET_ID = "Restaurant.get";
    public static final String GET_ALL = "Restaurant.getAll";

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("dateTime desc")
    protected List<Meal> menu;*/


    public Restaurant(){}

    public Restaurant(Restaurant re){
        this(re.getId(), re.getName());
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }


    /*public List<Meal> getMenu() {
        return menu;
    }

    public void setMenu(List<Meal> menu) {
        this.menu = menu;
    }*/
}
