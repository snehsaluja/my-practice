package com.practice.mypractice.programs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int n = heights.length;
        for (int i = 0; i < n - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff < 0) {
                continue;
            }
            bricks -= diff;
            pq.offer(diff);
            if (bricks < 0) {
                if (ladders > 0) {
                    ladders--;
                    bricks += pq.poll();
                } else {
                    return i;
                }
            }
        }
        return n - 1;
    }


}
