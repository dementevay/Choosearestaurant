package com.dementevay.voting.model;

import java.time.LocalDateTime;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
public class Meal extends NamedEntity {
    private Restaurant restaurant;//for restourant_id

    private LocalDateTime dateTime;

    private int price;//в копейках ru
}
