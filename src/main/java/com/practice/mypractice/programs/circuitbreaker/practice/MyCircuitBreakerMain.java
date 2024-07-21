package com.practice.mypractice.programs.circuitbreaker.practice;

import java.time.Duration;

public class MyCircuitBreakerMain {

    public static void main(String[] args) {

        MyCircuitBreaker circuitBreaker = new MyCircuitBreaker(3, Duration.ofSeconds(5));

        for (int i = 0; i < 10; i++) {
            try {
                String response = circuitBreaker.execute(() -> {
                    if (Math.random() > 0.5) {
                        throw new RuntimeException("Service Failed!");
                    }
                    return "Success - 200 OK!";
                });
                System.out.println("Service Call Succeeded = " + response);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // Simulate some delay between requests
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interruption in Thread execution");
            }
        }
    }
}
