package com.dementevay.voting.repository;

import com.dementevay.voting.model.Meal;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 27.07.17.
 */
@Repository
@Transactional(readOnly = true)
public class MealRepositoryImpl implements MealRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Meal get(int id) {
        Meal meal = em.createNamedQuery(Meal.GET, Meal.class).setParameter("id", id).getSingleResult();
        return meal;
    }

    @Override
    public List<Meal> getForRestaurantByDay(int restaurant_id, LocalDateTime dateTime) {
        return em.createNamedQuery(Meal.GET_FOR_RESTAURANT_BY_DAY, Meal.class)
                .setParameter("id", restaurant_id)
                .setParameter("dt", dateTime)
                .getResultList();
    }

    @Override
    public Meal getForRestaurant(int restaurant_id) {
        return null;
    }

    @Override
    @Transactional
    public void delete(int id, int user_id) {

    }

    @Override
    public List<Meal> getAll() {
        return null;
    }

    @Override
    @Transactional
    public Meal create(String name, String menu, int user_id) {
        return null;
    }

    @Override
    @Transactional
    public void update(int id, String name, String menu, int user_id) {

    }
}
