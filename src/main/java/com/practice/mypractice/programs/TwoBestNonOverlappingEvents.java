package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TwoBestNonOverlappingEvents {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int ans = 0, maxVal = 0;
        for (int[] event : events) {
            int start = event[0], end = event[1], value = event[2];

            while (!pq.isEmpty() && pq.peek()[0] < start) {
                maxVal = Math.max(maxVal, pq.poll()[1]);
            }
            ans = Math.max(ans, maxVal + value);
            pq.offer(new int[]{end, value});
        }
        return ans;
    }

}
