package com.practice.mypractice.programs.circuitbreaker.practice2;

import java.time.Duration;

public class CircuitBreakerMain {

    public static void main(String[] args) {
        CircuitBreaker cb = new CircuitBreaker(3, Duration.ofSeconds(5));

        for (int i = 0; i < 20; i++) {

            try {
                String response = cb.execute(() -> {
                    if (Math.random() > 0.5) {
                        return "Success";
                    } else {
                        throw new RuntimeException("Service Unavailable");
                    }
                });
                System.out.println("Service call succeeded = " + response);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted!");
            }
        }
    }
}
