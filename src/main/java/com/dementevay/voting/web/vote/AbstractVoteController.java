package com.dementevay.voting.web.vote;

import com.dementevay.voting.service.MealService;
import com.dementevay.voting.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Andrey Dementev on 31.07.17.
 */
public class AbstractVoteController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final RestaurantService service;
    protected final MealService serviceMeal;

    public AbstractVoteController(RestaurantService service, MealService serviceMeal) {
        this.service = service;
        this.serviceMeal = serviceMeal;
    }
}
