package com.dementevay.voting.web.meal;

import com.dementevay.voting.AuthorizedUser;
import com.dementevay.voting.model.Meal;
import com.dementevay.voting.service.meal.MealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Andrey Dementev on 27.07.17.
 */
public abstract class AbstractMealController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    protected final MealService serviceMeal;

    public AbstractMealController(MealService serviceMeal) {
        this.serviceMeal = serviceMeal;
    }

    public Meal get(int id) {
        LOG.info("get Meal {id}", id);
        return serviceMeal.get(id);
    }

    public List<Meal> getAll() {
        LOG.info("getAll Meals ");
        return serviceMeal.getAll();
    }

    public List<Meal> getForRestaurant(int restaurantId){
        LOG.info("get for restaurant meal restaurantId = {}", restaurantId);
        return serviceMeal.getForRestaurant(restaurantId);
    }

    public List<Meal> getForRestaurantByDay(int restaurantId, LocalDate localDate){
        LOG.info("get for restaurant(id = {}) by day meals, date {}", restaurantId, localDate);
        return serviceMeal.getForRestaurantByDay(restaurantId, localDate);
    }

    public void save (Meal meal) {
        LOG.info("save meal {} - id={} ", meal.getDescription(), meal.getId());
        serviceMeal.save(meal, AuthorizedUser.id());
    }

    public void delete (int id) {
        LOG.info("delete meal id = {} ", id);
        serviceMeal.delete(id, AuthorizedUser.id());
    }

    public void deleteAll () {
        LOG.info("delete all meals ");
        serviceMeal.deleteAll(AuthorizedUser.id());
    }

    public void deleteAllByDate (LocalDate localDate) {
        LOG.info("delete all meal by date - {} ", localDate);
        serviceMeal.deleteAllByDate(localDate, AuthorizedUser.id());
    }

    public void deleteByRestaurant(int restaurantId) {
        LOG.info("delete all meal by restaurant - {} ", restaurantId);
        serviceMeal.deleteByRestaurant(restaurantId, AuthorizedUser.id());
    }

    public void deleteByRestaurantAndDay(int restaurantId, LocalDate localDate) {
        LOG.info("delete meal by restaurant (id = {}) and date - {} ", restaurantId, localDate);
        serviceMeal.deleteByRestaurantAndDay(restaurantId, localDate, AuthorizedUser.id());
    }
}
