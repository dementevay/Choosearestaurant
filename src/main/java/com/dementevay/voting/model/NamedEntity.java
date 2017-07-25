package com.dementevay.voting.model;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
public class NamedEntity extends BaseEntity {
    protected String name;

    public NamedEntity() {
    }
    protected NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
