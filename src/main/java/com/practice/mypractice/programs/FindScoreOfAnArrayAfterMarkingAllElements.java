package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindScoreOfAnArrayAfterMarkingAllElements {

    public long findScore(int[] nums) {
        long sum = 0;
        int n = nums.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        boolean[] marked = new boolean[n];
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int index = pair[1];
            if (!marked[index]) {
                sum += pair[0];
                marked[index] = true;
                if (index + 1 < n) {
                    marked[index + 1] = true;
                }
                if (index - 1 >= 0) {
                    marked[index - 1] = true;
                }
            }
        }
        return sum;
    }

    public long findScoreOptimized(int[] nums) {
        long sum = 0;
        int n = nums.length;

        int[][] pq = new int[n][2];
        for (int i = 0; i < n; i++) {
            pq[i] = new int[]{nums[i], i};
        }
        Arrays.sort(pq,
                (a, b) -> {
                    if (a[0] == b[0]) {
                        return a[1] - b[1];
                    }
                    return a[0] - b[0];
                });

        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            int[] pair = pq[i];
            int index = pair[1];
            if (!marked[index]) {
                sum += pair[0];
                marked[index] = true;
                if (index + 1 < n) {
                    marked[index + 1] = true;
                }
                if (index - 1 >= 0) {
                    marked[index - 1] = true;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
