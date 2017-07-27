package com.dementevay.voting.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
@Entity
@Table(name = "meals")
public class Meal extends NamedEntity {

    @CollectionTable(name = "restaurants", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "restaurant_id", nullable = false)
    private int restaurant_id;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;
    //private Date registered = new Date();

    private int price;//в копейках ru
}
