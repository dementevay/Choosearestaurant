package com.dementevay.voting.model;

import java.time.LocalDateTime;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
public class Vote extends BaseEntity{
    private LocalDateTime dateTime;

    private User user;//for user_id

    private Restaurant restaurant;//for restourant_id
}
