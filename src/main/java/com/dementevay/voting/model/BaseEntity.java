package com.dementevay.voting.model;

import com.dementevay.voting.HasId;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
public class BaseEntity implements HasId {
    public int id;

    public BaseEntity() {
    }

    public BaseEntity(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
