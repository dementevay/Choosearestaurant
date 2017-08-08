package com.dementevay.voting.repository.vote;

import com.dementevay.voting.model.Role;
import com.dementevay.voting.model.User;
import com.dementevay.voting.model.Vote;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Andrey Dementev on 03.08.17.
 */
@Repository
@Transactional(readOnly = true)
public class VoteRepositoryImpl implements VoteRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Vote> getAllByDate(LocalDate localDate) {
        List<Vote> votes = em.createNamedQuery(Vote.GET_ALL_BY_DAY, Vote.class)
                .setParameter("date", localDate).getResultList();
        return votes;
    }

    public Vote getById(int id) {
        return em.createNamedQuery(Vote.GET_BY_ID, Vote.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Vote> getAll() {
        return em.createNamedQuery(Vote.GET_ALL, Vote.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Vote vote, int userId){
        if (isAdmin(userId)) {
            int id = isExist(userId, vote.getDate());
            if (id != 0) {
                vote.setId(id);
                em.merge(vote);
            } else {
                em.persist(vote);
            }
        }
    }

    private boolean isAdmin (int userId) {
        User u = em.createNamedQuery(User.GET_USER_ROLE, User.class)
                .setParameter("id", userId).getSingleResult();
        return u.getRoles().contains(Role.ROLE_ADMIN);
    }

    private int isExist (int userId, LocalDate date) {
        Vote vote;
        try {
             vote = em.createNamedQuery(Vote.IS_EXIST, Vote.class)
                    .setParameter("userId", userId)
                    .setParameter("date", date)
                    .getSingleResult();
        } catch (Exception e) {
            vote = null;
            System.out.printf("Vote at userId = %s and date = %s not found!", userId, date);
        }
        return (vote != null) ? vote.getId() : 0;
    }
}
