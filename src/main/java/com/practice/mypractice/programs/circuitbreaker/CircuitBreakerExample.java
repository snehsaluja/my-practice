package com.practice.mypractice.programs.circuitbreaker;

import java.time.Duration;

public class CircuitBreakerExample {

    public static void main(String[] args) {
        CircuitBreaker circuitBreaker = new CircuitBreaker(3, Duration.ofSeconds(5));

        for (int i = 0; i < 25; i++) {
            try {
                String result = circuitBreaker.execute(() -> {
                    // Simulating a service call
                    if (Math.random() > 0.5) {
                        throw new RuntimeException("RunTimeException!! Service failure");
                    }
                    return "Service response : 200 OK";
                });
                System.out.println("Service call succeeded: " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // Simulate some delay between requests
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
