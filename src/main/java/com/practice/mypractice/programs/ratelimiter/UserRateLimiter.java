package com.practice.mypractice.programs.ratelimiter;

import java.util.concurrent.ConcurrentHashMap;

public class UserRateLimiter {

    private final int userMaxRequest;
    private final int userWindowSizeInMillis;
    private final ConcurrentHashMap<String, SlidingWindowRateLimiter> userLimiters;

    public UserRateLimiter(int userMaxRequest, int userWindowSizeInMillis) {
        this.userMaxRequest = userMaxRequest;
        this.userWindowSizeInMillis = userWindowSizeInMillis;
        userLimiters = new ConcurrentHashMap<>();
    }

    public boolean allowRequest(String userId) {
        SlidingWindowRateLimiter limiter = userLimiters.computeIfAbsent(userId,
                k -> new SlidingWindowRateLimiter(userMaxRequest, userWindowSizeInMillis));
        return limiter.allowRequest();
    }

    public static void main(String[] args) {
        int maxReq = 5;
        int windowSize = 1000;
        String userId = "user1";
        UserRateLimiter rateLimit = new UserRateLimiter(maxReq, windowSize);

        for (int i = 0; i < 10; i++) {
            if (rateLimit.allowRequest(userId)) {
                System.out.println(userId + " allowed");
            } else {
                System.out.println(userId + " Not allowed");
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}
