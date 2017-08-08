package com.dementevay.voting.repository.vote;

import com.dementevay.voting.model.Vote;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Andrey Dementev on 03.08.17.
 */
public interface VoteRepository {

    List<Vote> getAll();

    List<Vote> getAllByDate(LocalDate localDate);

    Vote getById(int id);

    void save(Vote vote, int userId);
}
