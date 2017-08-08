package com.dementevay.voting.web.vote;

import com.dementevay.voting.AuthorizedUser;
import com.dementevay.voting.DateTimeForTests;
import com.dementevay.voting.model.Vote;
import com.dementevay.voting.service.meal.MealService;
import com.dementevay.voting.service.restaurants.RestaurantService;
import com.dementevay.voting.service.vote.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 31.07.17.
 */
public class AbstractVoteController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final VoteService service;

    public AbstractVoteController(VoteService service) {
        this.service = service;
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

    public int getWinnerOnDay(LocalDate localDate){
        LOG.info("get result voting by date {}", localDate);
        return service.getWinnerOnDay(localDate);
    }

    public void save(Vote vote){
        LOG.info("save Vote {}", vote.getUser_id());
        int userId = AuthorizedUser.id();
        service.save(vote, userId);
    }
}
