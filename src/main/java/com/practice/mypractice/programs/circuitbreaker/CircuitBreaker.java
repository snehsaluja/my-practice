package com.practice.mypractice.programs.circuitbreaker;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Supplier;

public class CircuitBreaker {

    private State state;
    private int failureCount;
    private final int failureThreshold;
    private final Duration timeout;
    private LocalDateTime lastFailureTime;

    public CircuitBreaker(int failureThreshold, Duration timeout) {
        this.state = State.CLOSED;
        this.failureThreshold = failureThreshold;
        this.timeout = timeout;
        this.failureCount = 0;
        this.lastFailureTime = LocalDateTime.now();
    }

    public synchronized <T> T execute(Supplier<T> supplier) throws Exception {
        switch (state) {
            case OPEN:
                if (LocalDateTime.now().isAfter(lastFailureTime.plus(timeout))) {
                    state = State.HALF_OPEN;
                } else {
                    throw new Exception("Circuit Breaker is OPEN. Service unavailable.");
                }
            case HALF_OPEN:
                try {
                    T result = supplier.get();
                    reset();
                    return result;
                } catch (Exception e) {
                    open();
                    throw new Exception("Service failed in HALF_OPEN state. Opening Circuit Breaker Again.");
                }
            case CLOSED:
                try {
                    T result = supplier.get();
                    reset();
                    return result;
                } catch (Exception e) {
                    failureCount++;
                    if (failureCount >= failureThreshold) {
                        open();
                        throw new Exception("Service failed. Failure count: " + failureCount + ". CIRCUIT IS NOW OPEN");
                    }
                    throw new Exception("Service failed. Failure count: " + failureCount);
                }
        }
        return null; // This line should never be reached.
    }

    private void reset() {
        state = State.CLOSED;
        failureCount = 0;
    }

    private void open() {
        state = State.OPEN;
        lastFailureTime = LocalDateTime.now();
    }

    public State getState() {
        return state;
    }
}

