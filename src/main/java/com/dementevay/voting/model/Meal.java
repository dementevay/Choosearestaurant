package com.dementevay.voting.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
@SuppressWarnings("JpaQlInspection")

@NamedQueries({
        @NamedQuery(name = Meal.GET_ALL, query = "SELECT m FROM Meal m ORDER BY m.id"),
        @NamedQuery(name = Meal.GET, query = "SELECT m FROM Meal m WHERE m.id = :id"),
        @NamedQuery(name = Meal.DELETE, query = "DELETE FROM Meal m WHERE m.id = :id"),
        @NamedQuery(name = Meal.GET_FOR_RESTAURANT, query = "SELECT m FROM Meal m WHERE m.restaurant_id = :id ORDER BY m.id"),
        @NamedQuery(name = Meal.GET_FOR_RESTAURANT_BY_DAY, query = "SELECT m FROM Meal m WHERE m.restaurant_id = :id and m.dateTime = :dt ORDER BY m.id")
})

@Entity
@Table(name = "meals")
public class Meal extends BaseEntity {

    public static final String GET_ALL = "Meal.getAll";
    public static final String GET = "Meal.get";
    public static final String DELETE = "Meal.delete";
    public static final String GET_FOR_RESTAURANT_BY_DAY = "Meal.get_for_RESTAURANT_by_day";
    public static final String GET_FOR_RESTAURANT = "Meal.get_for_RESTAURANT";

    @CollectionTable(name = "restaurants", joinColumns = @JoinColumn(name = "id"))
    @JoinColumn(name = "restaurant_id", nullable = false)
    private int restaurant_id;

    @Column(name = "description", nullable = false)
    @NotBlank
    private String description;

    @Column(name = "date_time", nullable = false)
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateTime;

    @Column(name = "price", nullable = false)
    @Range(min = 0, max = 10000000)
    private int price;//в копейках ru

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Restaurant restaurant;*/

    public Meal() {
    }
    public Meal(Integer id, Integer restaurant_id, String description, int price, LocalDate dateTime) {
        super(id);
        this.restaurant_id = restaurant_id;
        this.description = description;
        this.price = price;
        this.dateTime = dateTime;
    }
    public Meal(Meal m) {
        this(m.getId(), m.getRestaurant_id(), m.getDescription(), m.getPrice(), m.getDateTime());
    }
    public Meal(Integer restaurant_id, String description, int price, LocalDate dateTime) {
        this(null, restaurant_id, description, price, dateTime);
    }


    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

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

    @Override
    public String toString() {
        return this.getId().toString() + " " +
                this.restaurant_id + " " +
                this.getDateTime().toString() + " " +
                this.getDescription() + " " +
                this.getPrice();
    }
}
