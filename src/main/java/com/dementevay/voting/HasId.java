package com.dementevay.voting;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
public interface HasId {
    Integer getId();

    void setId(Integer id);

    default boolean isNew() {
        return (getId() == null);
    }
}
