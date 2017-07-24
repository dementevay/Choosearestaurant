package com.dementevay.voting.model;

import com.dementevay.voting.HasId;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
public class BaseEntity implements HasId {
    public BaseEntity() {
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }

    @Override
    public boolean isNew() {
        return false;
    }
}
