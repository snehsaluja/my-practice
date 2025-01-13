package com.practice.mypractice.programs;

/*

User requests for a service are routed through a rate limiting proxy to ensure that the network is not overloaded by non-critical requests.
The proxy has the following limits:

The number of requests in any given second cannot exceed 3
The number of requests in any given 10 seconds period cannot exceed 20
The number of requests in any given minute period exceed 20

Any request that exceeds any of the above limits will be dropped by the proxy. Given the times at which different requests arrive sorted ascending order, find how many requests will be dropped.

*/

import java.util.Deque;
import java.util.LinkedList;

public class RateLimitIncomingRequests {

    public boolean[] rateLimiter(int[] requests) {
        boolean[] allowable = new boolean[requests.length];

        Deque<Integer> q = new LinkedList<>();
        Deque<Integer> q2 = new LinkedList<>();
        Deque<Integer> q3 = new LinkedList<>();
        for (int i = 0; i < requests.length; i++) {
            while (!q.isEmpty() && q.peek() < requests[i] - 60) {
                q.poll();
            }
            while (!q2.isEmpty() && q2.peek() < requests[i] - 10) {
                q2.poll();
            }
            while (!q3.isEmpty() && q3.peek() < requests[i] - 1) {
                q3.poll();
            }
            boolean ans = true;
            if (q.size() > 20 || q2.size() > 20 || q3.size() > 3) {
                ans = false;
            }
            q.offerLast(requests[i]);
            q2.offerLast(requests[i]);
            q3.offerLast(requests[i]);
            allowable[i] = ans;
        }

        return allowable;
    }

    public boolean[] rateLimiter_usingSingleQueue(int[] requests) {
        boolean[] allowable = new boolean[requests.length];

        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < requests.length; i++) {
            while (!q.isEmpty() && q.peek() < requests[i] - 60) {
                q.poll();
            }

            boolean ans = true;
            int countTenSecRequests = countRequests(q, requests[i], 10);
            int countOneSecRequests = countRequests(q, requests[i], 1);
            if (q.size() > 20 || countTenSecRequests > 20 || countOneSecRequests > 3) {
                ans = false;
            }
            q.offer(requests[i]);
            allowable[i] = ans;
        }

        return allowable;
    }

    private int countRequests(LinkedList<Integer> window, int request, int range) {
        int count = 0;
        for (int i = window.size() - 1; i >= 0; i--) {
            if (request - window.get(i) < range) {
                count++;
            } else {
                break;
            }
        }
        /*
        for (int time : window) {
            if (time > request - range) {
                count++;
            }
        }*/
        return count;
    }

}
