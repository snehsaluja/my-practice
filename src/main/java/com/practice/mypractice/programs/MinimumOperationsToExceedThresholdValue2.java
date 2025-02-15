package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumOperationsToExceedThresholdValue2 {

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer((long) num);
        }
        int count = 0;
        while (pq.size() >= 2 && pq.peek() < k) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            pq.offer(Math.min(num1, num2) * 2 + Math.max(num1, num2));
            count++;
        }
        return count;
    }

    public int minOperations2(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (num < k)
                pq.offer((long) num);
        }
        int count = 0;
        while (!pq.isEmpty()) {
            count++;
            long num1 = pq.poll();
            if (pq.isEmpty())
                break;
            long num2 = pq.poll();
            long ans = num1 * 2 + num2;
            if (ans < k) {
                pq.offer(ans);
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
