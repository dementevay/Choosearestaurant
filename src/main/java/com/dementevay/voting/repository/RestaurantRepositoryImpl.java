package com.dementevay.voting.repository;

import com.dementevay.voting.to.RestaurantWithMenu;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 25.07.17.
 */
@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository{

    @PersistenceContext
    private EntityManager em;

    public RestaurantWithMenu get(int id, LocalDateTime dateTime) {
        return null;
    }

    public void delete(int id, int user_id) {

    }

    public List<RestaurantWithMenu> getAll(LocalDateTime dateTime) {
        return null;
    }

    public RestaurantWithMenu create(String name, String menu, int user_id) {
        return null;
    }

    public void update(int id, String name, String menu, int user_id) {

    }
}
