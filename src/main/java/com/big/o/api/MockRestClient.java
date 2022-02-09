package com.big.o.api;


import com.google.common.util.concurrent.Uninterruptibles;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class MockRestClient {

    private static Map<String, String> cache = new ConcurrentHashMap();
    private static final int LOGIN_REQUEST_DURATION = 200;

    public void login(String email, String password) {
        Uninterruptibles.sleepUninterruptibly(LOGIN_REQUEST_DURATION, TimeUnit.MILLISECONDS);
        System.out.println(String.format("Login with %s", email));
    }

    public void loginWithCache(String email, String password) {
        if (cache.containsKey(email)) {
            System.out.println("set token from cache");
        } else {
            Uninterruptibles.sleepUninterruptibly(LOGIN_REQUEST_DURATION, TimeUnit.MILLISECONDS);
            System.out.println(String.format("Login with %s", email));
            cache.put(email, "*******");
        }

    }

}
