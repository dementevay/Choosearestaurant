package com.dementevay.voting.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
//@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = Restaurant.GET_ALL,
                query = "SELECT r FROM Restaurant r")
})


@Entity
@Table(name = "restaurants")
public class Restaurant extends NamedEntity {
    public static final String GET_ALL = "Restaurant.getAll";
    public static final String DELETE = "Restaurant.delete";
    public static final String GET_BETWEEN = "Restaurant.getBetween";

}
