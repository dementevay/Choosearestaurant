package com.dementevay.voting.web.vote;

import com.dementevay.voting.model.Vote;
import com.dementevay.voting.service.vote.VoteService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Andrey Dementev on 31.07.17.
 */

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController extends AbstractVoteController{
    public static final String REST_URL = "/rest/votes";

    public VoteRestController(VoteService service) {
        super(service);
    }

    @GetMapping(value = "/")
    public List<Vote> getAll(){
        return super.getAll();
    }

    @Override
    @GetMapping(value = "/date/{date}")
    public List<Vote> getAllByDate(
            @PathVariable(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate){
        return super.getAllByDate(localDate);
    }

    @Override
    @GetMapping(value = "/{id}")
    public Vote getById(@PathVariable(value = "id") int id) {
        return super.getById(id);
    }

    @Override
    @GetMapping(value = "/winner/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getWinnerOnDay(@PathVariable(value = "date") LocalDate localDate) {
        return super.getWinnerOnDay(localDate);
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody Vote vote) {
        super.save(vote);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Vote vote) {
        save(vote);
    }

    public void delete(){} //Removing voices is not good idea! (Only if your very need it.)
}
