package com.dementevay.voting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
@Entity
@Table(name = "meals")
public class Meal extends NamedEntity {

    @Column(name = "restaurant_id", nullable = false)
    private int restaurant_id;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;
    //private Date registered = new Date();

    private int price;//в копейках ru
}
