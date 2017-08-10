package com.dementevay.voting.repository.meal;

import com.dementevay.voting.model.Meal;
import com.dementevay.voting.model.Role;
import com.dementevay.voting.model.User;
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
                .setParameter("dt", dateTime.toLocalDate())
                .getResultList();
    }

    @Override
    public List<Meal> getForRestaurant(int restaurant_id) {
        return em.createNamedQuery(Meal.GET_FOR_RESTAURANT, Meal.class)
                .setParameter("id", restaurant_id)
                .getResultList();
    }

    @Override
    @Transactional
    public void delete(int id, int userId) {
        if (isAdmin(userId)) {
            em.createNamedQuery(Meal.DELETE).setParameter("id", id).executeUpdate();
        }
    }

    @Override
    public List<Meal> getAll() {
        return null;
    }

    @Override
    @Transactional
    public void save(Meal meal, int userId) {
        if (isAdmin(userId)) {
            if (meal.isNew()) {
                em.persist(meal);
            } else {
                em.merge(meal);
            }
        }
    }

    @Override
    @Transactional
    public Meal create(String name, String menu, int userId) {
        return null;
    }

    @Override
    @Transactional
    public void update(int id, String name, String menu, int userId) {

    }

    private boolean isAdmin (int userId) {
        User u = em.createNamedQuery(User.GET_USER_ROLE, User.class)
                .setParameter("id", userId).getSingleResult();
        return u.getRoles().contains(Role.ROLE_ADMIN);
    }
}
