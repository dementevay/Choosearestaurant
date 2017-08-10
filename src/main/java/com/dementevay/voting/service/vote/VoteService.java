package com.dementevay.voting.service.vote;

import com.dementevay.voting.model.Vote;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Andrey Dementev on 03.08.17.
 */
public interface VoteService {

    List<Vote> getAll();

    List<Vote> getAllByDate(LocalDate localDate);

    Vote getById(int id);

    Vote getByUserId(int user_id);

    int getWinnerOnDay(LocalDate localDate);

    void save(Vote vote, int userId);
}
