package com.dementevay.voting.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
@NamedQueries({
        @NamedQuery(name = Restaurant.GET_ID, query = "SELECT r FROM Restaurant r WHERE r.id = :id"),
        @NamedQuery(name = Restaurant.GET_ALL, query = "SELECT r FROM Restaurant r"),
        @NamedQuery(name = Restaurant.DELETE_ID, query = "DELETE FROM Restaurant r WHERE r.id = :id"),
        @NamedQuery(name = Restaurant.DELETE_ALL, query = "DELETE FROM Restaurant r")
})


@Entity
@Table(name = "restaurants")
public class Restaurant extends NamedEntity {
    public static final String GET_ID = "Restaurant.get";
    public static final String GET_ALL = "Restaurant.getAll";
    public static final String DELETE_ID = "Restaurant.delete_id";
    public static final String DELETE_ALL = "Restaurant.delete_all";

    public Restaurant(){}

    public Restaurant(Restaurant re){
        this(re.getId(), re.getName());
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    public Restaurant(String name) {
        this(null, name);
    }
}
