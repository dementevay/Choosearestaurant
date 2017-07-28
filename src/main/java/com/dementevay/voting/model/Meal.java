package com.dementevay.voting.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
@SuppressWarnings("JpaQlInspection")

@NamedQueries({
        @NamedQuery(name = Meal.GET_ALL, query = "SELECT m FROM Meal m"),
        @NamedQuery(name = Meal.GET, query = "SELECT m FROM Meal m WHERE m.id = :id"),
        @NamedQuery(name = Meal.GET_FOR_RESTAURANT_BY_DAY, query = "SELECT m FROM Meal m WHERE m.restaurant_id = :id and m.dateTime = :dt")
})

@Entity
@Table(name = "meals")
public class Meal extends BaseEntity {

    public static final String GET_ALL = "Meal.getAll";
    public static final String GET = "Meal.get";
    public static final String DELETE = "Meal.delete";
    public static final String GET_FOR_RESTAURANT_BY_DAY = "Meal.get_for_RESTAURANT_by_day";

    @CollectionTable(name = "restaurants", joinColumns = @JoinColumn(name = "id"))
    @JoinColumn(name = "restaurant_id", nullable = false)
    private int restaurant_id;

    @Column(name = "description", nullable = false)
    @NotBlank
    private String description;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "price", nullable = false)
    @Length(min = 1, max = 10000000)
    private int price;//в копейках ru

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Restaurant restaurant;*/

    public Meal() {
    }
    public Meal(Integer id, Integer restaurant_id, String description, int price, LocalDateTime dateTime) {
        super(id);
        this.restaurant_id = restaurant_id;
        this.description = description;
        this.price = price;
        this.dateTime = dateTime;
    }
    public Meal(Meal m) {
        this(m.getId(), m.getRestaurant_id(), m.getDescription(), m.getPrice(), m.getDateTime());
    }
    public Meal(Integer restaurant_id, String description, int price, LocalDateTime dateTime) {
        this(null, restaurant_id, description, price, dateTime);
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /*public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }*/

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
