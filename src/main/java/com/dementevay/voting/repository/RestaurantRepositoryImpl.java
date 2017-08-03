package com.dementevay.voting.repository;

import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.model.Role;
import com.dementevay.voting.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Restaurant get(int id) {
        return em.createNamedQuery(Restaurant.GET_ID, Restaurant.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Restaurant> getAll() {
        return em.createNamedQuery(Restaurant.GET_ALL, Restaurant.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Restaurant restaurant, int userId) {
        if (isAdmin(userId)) {
            if (restaurant.isNew()) {
                em.persist(restaurant);
            } else {
                em.merge(restaurant);
            }
        }
    }

    @Override
    @Transactional
    public void delete(int id, int userId) {
        if (isAdmin(userId)) {
             em.createNamedQuery(Restaurant.DELETE_ID).setParameter("id", id).executeUpdate();
        }
    }

    @Override
    @Transactional
    public void deleteAll(int userId) {
        if (isAdmin(userId)) {
            em.createNamedQuery(Restaurant.DELETE_ALL).executeUpdate();
        }
    }

    private boolean isAdmin (int userId) {
        User u = em.createNamedQuery(User.GET_USER_ROLE, User.class)
                .setParameter("id", userId).getSingleResult();
        return u.getRoles().contains(Role.ROLE_ADMIN);
    }
}
