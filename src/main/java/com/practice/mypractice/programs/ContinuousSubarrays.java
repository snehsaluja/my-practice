package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ContinuousSubarrays {

    public long continuousSubarrays(int[] nums) {
        long count = 0;
        int l = 0, r = 0;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        while (r < nums.length) {
            maxHeap.offer(new int[]{nums[r], r});
            minHeap.offer(new int[]{nums[r], r});

            while (!maxHeap.isEmpty() && !minHeap.isEmpty() && (maxHeap.peek()[0] - minHeap.peek()[0] > 2)) {
                l++;
                while (!maxHeap.isEmpty() && maxHeap.peek()[1] < l) {
                    maxHeap.poll();
                }
                while (!minHeap.isEmpty() && minHeap.peek()[1] < l) {
                    minHeap.poll();
                }
            }
            count += (r - l + 1);
            r++;
        }

        return count;
    }

    public long continuousSubarraysOptimized(int[] nums) {
        long count = 0;
        int j = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while ((i - j + 1) > getCount(nums[i], map)) {
                map.put(nums[j], map.get(nums[j]) - 1);
                j++;
            }
            count += i - j + 1;
        }
        return count;
    }

    private int getCount(int num, Map<Integer, Integer> map) {
        return map.getOrDefault(num, 0) + map.getOrDefault(num + 1, 0) +
                map.getOrDefault(num + 2, 0) + map.getOrDefault(num - 1, 0) +
                map.getOrDefault(num - 2, 0);
    }

    public static void main(String[] args) {

    }

}
