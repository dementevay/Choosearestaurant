package com.dementevay.voting.repository;

import com.dementevay.voting.model.Meal;
import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.util.TimeUtil;
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

    public Restaurant get(int id) {
        return em.createNamedQuery(Restaurant.GET_ID, Restaurant.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    public void delete(int id, int user_id) {

    }

    public List<Restaurant> getAll() {
        return em.createNamedQuery(Restaurant.GET_ALL, Restaurant.class).getResultList();
    }

    public List<Restaurant> getSS() {
        //return em.createNamedQuery(Meal.GET_ALL,Meal.class).setParameter("userId", userId).getResultList();
        //LocalDateTime dateTime = TimeUtil.stringToLocalDateTime("2017-07-26 10:00:00");
        List<Restaurant> list = em.createNamedQuery(Restaurant.GET_ALL, Restaurant.class).getResultList();
        /*for (Restaurant r: list) {
            r.setMenu(em.createNamedQuery(Meal.GET_FOR_RESTAURANT_BY_DAY, Meal.class)
                    .setParameter("id", r.getId()).setParameter("dt", dateTime)
                    .getResultList());
        }*/
        return list;
    }

    @Transactional
    public Restaurant create(String name, String menu, int user_id) {
        return null;
    }

    @Transactional
    public void update(int id, String name, String menu, int user_id) {

    }
}
