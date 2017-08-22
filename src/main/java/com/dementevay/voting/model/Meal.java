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
        @NamedQuery(name = Meal.DELETE_ALL_BY_DATE, query = "DELETE FROM Meal m WHERE m.date = :date"),
        @NamedQuery(name = Meal.DELETE_ALL, query = "DELETE FROM Meal m"),
        @NamedQuery(name = Meal.DELETE_BY_RESTAURANT_DATE, query = "DELETE FROM Meal m WHERE m.date = :date AND m.restaurantId = :restaurantId"),
        @NamedQuery(name = Meal.DELETE_BY_RESTAURANT, query = "DELETE FROM Meal m WHERE m.restaurantId = :restaurantId"),
        @NamedQuery(name = Meal.GET_FOR_RESTAURANT, query = "SELECT m FROM Meal m WHERE m.restaurantId = :id ORDER BY m.id"),
        @NamedQuery(name = Meal.GET_FOR_RESTAURANT_BY_DAY, query = "SELECT m FROM Meal m WHERE m.restaurantId = :id and m.date = :dt ORDER BY m.id")
})

@Entity
@Table(name = "meals")
public class Meal extends BaseEntity {

    public static final String GET_ALL = "Meal.getAll";
    public static final String GET = "Meal.get";
    public static final String DELETE = "Meal.delete";
    public static final String DELETE_ALL = "Meal.delete all";
    public static final String DELETE_ALL_BY_DATE = "Meal.delete all by date";
    public static final String DELETE_BY_RESTAURANT_DATE = "Meal.delete by restaurant and date";
    public static final String DELETE_BY_RESTAURANT = "Meal.delete by restaurant ";
    public static final String GET_FOR_RESTAURANT_BY_DAY = "Meal.get for RESTAURANT by day";
    public static final String GET_FOR_RESTAURANT = "Meal.get for RESTAURANT";

    @CollectionTable(name = "restaurants", joinColumns = @JoinColumn(name = "id"))
    @JoinColumn(name = "restaurantId", nullable = false)
    private int restaurantId;

    @Column(name = "description", nullable = false)
    @NotBlank
    private String description;

    @Column(name = "date", nullable = false)
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

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
    public Meal(Integer id, Integer restaurantId, String description, int price, LocalDate date) {
        super(id);
        this.restaurantId = restaurantId;
        this.description = description;
        this.price = price;
        this.date = date;
    }
    public Meal(Meal m) {
        this(m.getId(), m.getRestaurantId(), m.getDescription(), m.getPrice(), m.getDate());
    }
    public Meal(Integer restaurantId, String description, int price, LocalDate date) {
        this(null, restaurantId, description, price, date);
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate dateTime) {
        this.date = dateTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
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
                this.restaurantId + " " +
                this.getDate().toString() + " " +
                this.getDescription() + " " +
                this.getPrice();
    }
}
