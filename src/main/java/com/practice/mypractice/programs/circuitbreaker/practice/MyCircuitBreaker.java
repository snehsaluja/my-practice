package com.practice.mypractice.programs.circuitbreaker.practice;

import com.practice.mypractice.programs.circuitbreaker.State;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Supplier;

public class MyCircuitBreaker {

    @Getter
    private State state;
    private int failureCount;
    private final int failureThreshold;
    private final Duration timeout;
    private LocalDateTime lastFailureTime;

    public MyCircuitBreaker(int failureThreshold, Duration timeout) {
        this.failureThreshold = failureThreshold;
        this.timeout = timeout;
        this.state = State.CLOSED;
        this.lastFailureTime = LocalDateTime.now();
        this.failureCount = 0;
    }

    public <T> T execute(Supplier<T> supplier) {

        switch (state) {
            case OPEN: {
                if (LocalDateTime.now().isAfter(lastFailureTime.plus(timeout))) {
                    state = State.HALF_OPEN;
                } else {
                    throw new RuntimeException("Circuit Breaker is Open, Service Unavailable.");
                }
            }
            case HALF_OPEN: {
                try {
                    T result = supplier.get();
                    reset();
                    //System.out.println("Request successful");
                    return result;
                } catch (Exception e) {
                    throw new RuntimeException("Request Failure in HALF_OPEN state. Keeping the circuit OPENED");
                }
            }
            case CLOSED: {
                try {
                    T result = supplier.get();
                    reset();
                    //System.out.println("Request successful");
                    return result;
                } catch (Exception e) {
                    failureCount++;
                    lastFailureTime = LocalDateTime.now();
                    if (failureCount >= failureThreshold) {
                        open();
                        throw new RuntimeException("Request Failure. Failure Count = " + failureCount + ". OPENING the circuit!");
                    }
                    throw new RuntimeException("Request Failure. Failure Count = " + failureCount);
                }
            }
        }
        return null;
    }

    private void reset() {
        state = State.CLOSED;
        failureCount = 0;
    }

    private void open() {
        state = State.OPEN;
        lastFailureTime = LocalDateTime.now();
    }
}
