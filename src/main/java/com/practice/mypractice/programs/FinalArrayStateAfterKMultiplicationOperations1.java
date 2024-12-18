package com.practice.mypractice.programs;

import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperations1 {

    public int[] getFinalState(int[] nums, int k, int multiplier) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        for (int i = 0; i < k; i++) {
            int[] arr = pq.poll();
            nums[arr[1]] *= multiplier;
            pq.offer(new int[]{nums[arr[1]], arr[1]});
        }

        return nums;
    }

    public static void main(String[] args) {

    }
}
