package com.dementevay.voting.service.vote;

import com.dementevay.voting.model.Vote;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Andrey Dementev on 03.08.17.
 */
public interface VoteService {

    List<Vote> getAll();

    List<Vote> getAllByDate(LocalDate localDate);

    Vote getById(int id);

    int getWinnerOnDay(LocalDate localDate);

    void save(Vote vote, int userId);
}
