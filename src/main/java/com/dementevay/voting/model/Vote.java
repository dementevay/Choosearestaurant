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
        @NamedQuery(name = Vote.GET_BY_USER_ID, query = "SELECT v FROM Vote v WHERE v.userId = :userId"),
        @NamedQuery(name = Vote.GET_ALL, query = "SELECT v FROM Vote v"),
        @NamedQuery(name = Vote.SAVE, query = "SELECT v FROM Vote v WHERE v.id = :id"),
        @NamedQuery(name = Vote.IS_EXIST, query = "SELECT v FROM Vote v WHERE v.userId = :userId AND v.date = :date")
})

@Entity
@Table(name = "votes")
public class Vote extends BaseEntity{
    public static final String GET_ALL_BY_DAY = "Vote.get all by day";
    public static final String GET_BY_ID = "Vote.get by id";
    public static final String GET_BY_USER_ID = "Vote.get by user id";
    public static final String GET_ALL = "Vote.get all";
    public static final String SAVE = "Vote.save";
    public static final String IS_EXIST = "Vote.is exist";

    @Column(name = "date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @CollectionTable(name = "users", joinColumns = @JoinColumn(name = "id"))
    @JoinColumn(name = "userId", nullable = false)
    private int userId;

    @CollectionTable(name = "restaurants", joinColumns = @JoinColumn(name = "id"))
    @JoinColumn(name = "restaurantId", nullable = false)
    private int restaurantId;

    public Vote() {
    }

    public Vote(Integer id, LocalDate date, int userId, int restaurantId){
        super(id);
        this.date = date;
        this.userId = userId;
        this.restaurantId = restaurantId;
    }

    public Vote(Vote vote){
        this(vote.getId(), vote.getDate(), vote.getUserId(), vote.getRestaurantId());
    }

    public Vote(LocalDate date, int userId, int restaurantId){
        this(null, date, userId, restaurantId);

    }

    public int getUserId() {
        return userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }


}
