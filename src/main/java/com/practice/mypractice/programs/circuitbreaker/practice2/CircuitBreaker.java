package com.practice.mypractice.programs.circuitbreaker.practice2;

import com.practice.mypractice.programs.circuitbreaker.State;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Supplier;

public class CircuitBreaker {

    private State state;
    private int failureCount;
    private int failureThreshold;
    private LocalDateTime lastFailureTime;
    private Duration timeout;

    public CircuitBreaker(int failureThreshold, Duration timeout) {
        this.state = State.CLOSED;
        this.failureCount = 0;
        this.failureThreshold = failureThreshold;
        this.lastFailureTime = null;
        this.timeout = timeout;
    }

    public synchronized <T> T execute(Supplier<T> supplier) {

        switch (state) {
            case OPEN:
                if (LocalDateTime.now().isAfter(lastFailureTime.plus(timeout))) {
                    state = State.HALF_OPEN;
                } else {
                    throw new RuntimeException("Circuit is OPEN! Service Unavailable");
                }
            case HALF_OPEN:
                try {
                    T response = supplier.get();
                    reset();
                    return response;
                } catch (Exception e) {
                    open();
                    throw new RuntimeException("Service Failed in HALF_OPEN STATE! Opening the circuit again!");
                }
            case CLOSED:
                try {
                    T response = supplier.get();
                    reset();
                    return response;
                } catch (Exception e) {
                    failureCount++;
                    if (failureCount > failureThreshold) {
                        open();
                        throw new RuntimeException("Failure Count > Threshold. Opening the Circuit!!! Failure Count : " + failureCount);
                    }
                    throw new RuntimeException("Service Failed. Failure Count : " + failureCount);
                }
        }
        return null;
    }

    private void open() {
        state = State.OPEN;
        lastFailureTime = LocalDateTime.now();
    }

    private void reset() {
        state = State.CLOSED;
        failureCount = 0;
    }

}
