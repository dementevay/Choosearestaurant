package com.dementevay.voting.web.vote;

import com.dementevay.voting.AuthorizedUser;
import com.dementevay.voting.model.Vote;
import com.dementevay.voting.service.restaurants.RestaurantService;
import com.dementevay.voting.service.vote.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 31.07.17.
 */
public class AbstractVoteController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final VoteService service;
    private final RestaurantService restaurantService;

    public AbstractVoteController(VoteService service, RestaurantService restaurantService) {
        this.service = service;
        this.restaurantService = restaurantService;
    }

    public List<Vote> getAll(){
        return service.getAll();
    }

    public List<Vote> getAllByDate(LocalDate localDate) {
        LOG.info("get all Votes by date {}", localDate);
        return service.getAllByDate(localDate);
    }

    public Vote getById(int id) {
        return service.getById(id);
    }

    public Vote getByUserId(int user_id) {
        return service.getByUserId(user_id);
    }

    public int getWinnerOnDay(LocalDate localDate){
        LOG.info("get result voting by date {}", localDate);
        return service.getWinnerOnDay(localDate);
    }

    public String getStringWinnerOnDay(LocalDate localDate, LocalTime localTime){
        String str = " ";
        if(localTime.isAfter(LocalTime.parse("10:59"))) {
            int restaurant_id = this.getWinnerOnDay(localDate);
            str = (restaurant_id == 0) ? " " : restaurantService.get(restaurant_id).getName();
        }
        return str;
    }

    public void save(Vote vote){
        LOG.info("save Vote {}", vote.getUserId());
        int userId = AuthorizedUser.id();
        service.save(vote, userId);
    }
}
