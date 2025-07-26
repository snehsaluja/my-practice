package com.practice.mypractice.interview27;

// Paypal Round 1 (5th Dec):


/*
You have n chocolates with weights given by an array weights[n], where weights[i] is the weight of the ith chocolate.
Each day, you can pick a chocolate, eat half (calculated as floor(weights[i]/2)),
and return the remaining half. Determine the minimum possible total weight of the chocolates after d days.
Note that you may eat from the same chocolate multiple times.

Example:
chocolates = [30, 20, 25] ; d = 4;

output = 8 + 10 + 13 = 31

The total weight of chocolates on day 4 is 8 + 10 + 13, which is the minimum possible weight after 4 days.

Function Description
Complete the function findMinWeight in the editor below.

'findMinWeight' has the following parameters:
int weights[n]: an array of integers representing weights of chocolates, indexed O to n-1 int d: an integer representing the number of days


Returns
int: the minimum total weight of chocolate after d days.

*/

import java.util.List;
import java.util.PriorityQueue;

public class MinimumTotalWeight {

    // k deletion , n+k insertion
    // Finding Max element = 0(1)
    // Deleting Max = 0(log n)
    // inserting 1 element = 0(log n) ; for n element = O(n * log n)
    // Overall time = O(n * Log n + k * log n + n log n) = O ((2n+k) Log n) = O((n+k) * Log n)
    // overall time = 0((n+k) * Log n)
    // Space = O(n)
    public static int findMinWeight(List<Integer> weights, int d) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int i = 0; i < weights.size(); i++) {
            pq.offer(weights.get(i));               // O(n * log n)
        }
        for (int i = 0; i < d; i++) {               // k => O (2 * k * log n) = O(k * log n)
            int maxChocWeight = pq.poll();          // k = k log n
            maxChocWeight = (int) Math.ceil(maxChocWeight / (double) 2);
            pq.offer(maxChocWeight);                // k log n
        }
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
}
