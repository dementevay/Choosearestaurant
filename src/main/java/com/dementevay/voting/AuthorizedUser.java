package com.dementevay.voting;

import com.dementevay.voting.model.BaseEntity;

/**
 * Created by Andrey Dementev on 31.07.17.
 */
public class AuthorizedUser {
    private AuthorizedUser(){}
    public static int id = BaseEntity.START_SEQ;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }

}
