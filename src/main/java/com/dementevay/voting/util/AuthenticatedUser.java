package com.dementevay.voting.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrey Dementev on 08.08.17.
 */
public class AuthenticatedUser {
    private static Map<Integer, String> map = new HashMap<>();
    static {
        map.put(100000, "Админ");
        map.put(100001, "Пользователь 1");
        map.put(100002, "Пользователь 2");
        map.put(100003, "Пользователь 3");
    }
    private AuthenticatedUser(){}

    public static String getName(int userId) {
        return map.get(userId);
    }
}
