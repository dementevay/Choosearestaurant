package com.dementevay.voting.web.restaurant;

import com.dementevay.voting.AuthorizedUser;
import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.service.meal.MealService;
import com.dementevay.voting.service.restaurants.RestaurantService;
import com.dementevay.voting.to.RestaurantWithMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Andrey Dementev on 25.07.17.
 */
public abstract class RestaurantAbstractController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    protected final RestaurantService serviceRestaurant;
    protected final MealService serviceMeal;

    public RestaurantAbstractController(RestaurantService restaurantService, MealService serviceMeal) {
        this.serviceRestaurant = restaurantService;
        this.serviceMeal = serviceMeal;
    }

    public List<RestaurantWithMenu> getAll() {
        LOG.info("get all Restaurant");
        return serviceRestaurant.getAll().stream()
                .map(r -> new RestaurantWithMenu(r, serviceMeal.getForRestaurant(r.getId())))
                .collect(Collectors.toList());
    }

    public List<RestaurantWithMenu> getAllByDate(LocalDateTime dateTime) {
        LOG.info("get all Restaurant by date {}", dateTime);
        return serviceRestaurant.getAll().stream()
                .map(r -> new RestaurantWithMenu(r, serviceMeal.getForRestaurantByDay(r.getId(), dateTime)))
                .collect(Collectors.toList());
    }

    public RestaurantWithMenu get(int id) {
        LOG.info("get Restaurant {}", id);
        return new RestaurantWithMenu(serviceRestaurant.get(id), serviceMeal.getForRestaurant(id));
    }

    public RestaurantWithMenu getForDate(int id, LocalDateTime dateTime) {
        LOG.info("get Restaurant {} for Date {}", id, dateTime);
        return new RestaurantWithMenu(serviceRestaurant.get(id)
                , serviceMeal.getForRestaurantByDay(id, dateTime));
    }

    public void save(RestaurantWithMenu restaurant) {
        LOG.info("create/update Restaurant {}", restaurant.getName());
        int userId = AuthorizedUser.id();

        Restaurant rest = new Restaurant(
                restaurant.isNew() ? null : restaurant.getId(),
                restaurant.getName());
        final int id = serviceRestaurant.save(rest, userId);

        restaurant.getMenu().forEach(m ->
        {
            m.setRestaurant_id(id);
            serviceMeal.save(m, userId);
        });
    }

    public void delete(int id) {
        LOG.info("delete Restaurant {}", id);
        int userId = AuthorizedUser.id();
        serviceRestaurant.delete(id, userId);
    }

    public void deleteAll() {
        LOG.info("delete ALL Restaurant");
        int userId = AuthorizedUser.id();
        serviceRestaurant.deleteAll(userId);
    }


}
