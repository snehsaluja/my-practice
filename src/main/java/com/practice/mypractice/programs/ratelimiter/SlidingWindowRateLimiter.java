package com.practice.mypractice.programs.ratelimiter;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowRateLimiter {

    private final int maxRequests;

    private final int windowSizeInMillis;

    private final Queue<Long> requestTimeStamps;

    public SlidingWindowRateLimiter(int maxRequests, int windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
        this.requestTimeStamps = new LinkedList<>();
    }

    public boolean allowRequest() {
        long now = System.currentTimeMillis();
        while (!requestTimeStamps.isEmpty() && requestTimeStamps.peek() < now - windowSizeInMillis) {
            requestTimeStamps.poll();
        }
        if (requestTimeStamps.size() >= maxRequests) {
            return false;
        } else {
            requestTimeStamps.add(now);
            return true;
        }
    }
}
