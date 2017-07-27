package com.dementevay.voting.repository;

import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.to.RestaurantWithMenu;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 25.07.17.
 */
@Repository
@Transactional(readOnly = true)
public class RestaurantRepositoryImpl implements RestaurantRepository{

    @PersistenceContext
    private EntityManager em;

    public RestaurantWithMenu get(int id, LocalDateTime dateTime) {
        return null;
    }

    @Transactional
    public void delete(int id, int user_id) {

    }

    public List<RestaurantWithMenu> getAll(LocalDateTime dateTime) {
        return null;//em.createNamedQuery(Restaurant.GET_ALL, Restaurant.class).setParameter(dateTime).getResultList();
    }

    public List<Restaurant> getSS() {
        //return em.createNamedQuery(Meal.GET_ALL,Meal.class).setParameter("userId", userId).getResultList();
        List<Restaurant> list =
                em.createNamedQuery(Restaurant.GET_ALL, Restaurant.class)
                        .getResultList();
        return list;
    }

    @Transactional
    public RestaurantWithMenu create(String name, String menu, int user_id) {
        return null;
    }

    @Transactional
    public void update(int id, String name, String menu, int user_id) {

    }
}
