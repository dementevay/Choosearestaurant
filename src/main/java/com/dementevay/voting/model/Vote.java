package com.dementevay.voting.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
@NamedQueries({
        @NamedQuery(name = Vote.GET_ALL_BY_DAY, query = "SELECT v FROM Vote v WHERE v.date = :date"),
        @NamedQuery(name = Vote.GET_BY_ID, query = "SELECT v FROM Vote v WHERE v.id = :id"),
        @NamedQuery(name = Vote.GET_BY_USER_ID, query = "SELECT v FROM Vote v WHERE v.user_id = :user_id"),
        @NamedQuery(name = Vote.GET_ALL, query = "SELECT v FROM Vote v"),
        @NamedQuery(name = Vote.SAVE, query = "SELECT v FROM Vote v WHERE v.id = :id"),
        @NamedQuery(name = Vote.IS_EXIST, query = "SELECT v FROM Vote v WHERE v.user_id = :userId AND v.date = :date")
})

@Entity
@Table(name = "votes")
public class Vote extends BaseEntity{
    public static final String GET_ALL_BY_DAY = "Vote.getAllByDay";
    public static final String GET_BY_ID = "Vote.getById";
    public static final String GET_BY_USER_ID = "Vote.getByUserId";
    public static final String GET_ALL = "Vote.getAll";
    public static final String SAVE = "Vote.save";
    public static final String IS_EXIST = "Vote.isExist";

    @Column(name = "date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @CollectionTable(name = "users", joinColumns = @JoinColumn(name = "id"))
    @JoinColumn(name = "user_id", nullable = false)
    private int user_id;

    @CollectionTable(name = "restaurants", joinColumns = @JoinColumn(name = "id"))
    @JoinColumn(name = "restaurant_id", nullable = false)
    private int restaurant_id;

    public Vote() {
    }

    public Vote(Integer id, LocalDate date, int userId, int restaurantId){
        super(id);
        this.date = date;
        this.user_id = userId;
        this.restaurant_id = restaurantId;
    }

    public Vote(Vote vote){
        this(vote.getId(), vote.getDate(), vote.getUser_id(), vote.getRestaurant_id());
    }

    public Vote(LocalDate date, int user_id, int restaurant_id){
        this(null, date, user_id, restaurant_id);

    }

    public int getUser_id() {
        return user_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }


}
