package com.dementevay.voting.service.vote;

import com.dementevay.voting.DateTimeForTests;
import com.dementevay.voting.model.Vote;
import com.dementevay.voting.repository.vote.VoteRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Andrey Dementev on 03.08.17.
 */
@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository repository;

    public VoteServiceImpl(VoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Vote> getAllByDate(LocalDate localDate) {
        return repository.getAllByDate(localDate);
    }

    public Vote getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Vote> getAll() {
        return repository.getAll();
    }

    @Override
    public int getWinnerOnDay(LocalDate localDate) {
        List<Vote> votes = repository.getAllByDate(localDate);
        Map<Integer, Integer> map = new HashMap<>();
        votes.forEach(v -> map.merge(v.getRestaurant_id(), 1, (k, v1) -> v1+1));
        int i = 0;
        int idWinner = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            int value = m.getValue();
            if (value > i){
                i = value;
                idWinner = m.getKey();
            }
        }
        return idWinner;
    }

    @Override
    public void save(Vote vote, int userId) {
        //TODO : uncomment for real work
      /*LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();*/
        LocalDate dateNow = DateTimeForTests.localDate;
        LocalTime timeNow = DateTimeForTests.localTime;

        if(timeNow.isBefore(LocalTime.parse("11:00")) && vote.getDate().equals(dateNow)) {
            repository.save(vote, userId);
        }
    }

}
