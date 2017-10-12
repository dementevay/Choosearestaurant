package com.dementevay.voting.web.vote;

import com.dementevay.voting.AuthorizedUser;
import com.dementevay.voting.model.Vote;
import com.dementevay.voting.service.restaurants.RestaurantService;
import com.dementevay.voting.service.vote.VoteService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.dementevay.voting.DateTimeForTests.*;

/**
 * Created by Andrey Dementev on 11.10.17.
 */
@RestController
@RequestMapping(value = "/ajax/votes")
public class VoteAjaxController extends AbstractVoteController {
    public VoteAjaxController(VoteService service, RestaurantService restaurantService) {
        super(service, restaurantService);
    }

    @PostMapping("/{id}")
    public String save(@PathVariable("id") int restaurantId) {
        if (localTime.isAfter(elevenOclock)){
            return "";
        } else {
            Vote vote = new Vote(null, localDate, AuthorizedUser.id(), restaurantId);
            super.save(vote);
            return "vote is saved";
        }
    }

    @PostMapping("/getIdRestaurantMyVote/")
    public int getIdRestaurantMyVote() {
        return super.getByUserId(AuthorizedUser.id()).getRestaurantId();
    }
}
