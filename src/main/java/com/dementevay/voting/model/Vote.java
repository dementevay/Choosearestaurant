package com.dementevay.voting.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
@Entity
@Table(name = "vote")
public class Vote extends BaseEntity{

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @JoinColumn(name = "user_id", nullable = false)
    private int user_id;

    @JoinColumn(name = "restaurant_id", nullable = false)
    private int restaurant_id;

    public Vote() {
    }
}
