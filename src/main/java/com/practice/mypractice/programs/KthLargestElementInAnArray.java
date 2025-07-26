package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int num : nums) {
            pq.offer(num);
        }
        int capture = 0;
        for (int i = 0; i < k; i++) {
            capture = pq.poll();
        }
        return capture;
    }

    public int findKthLargest_2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {

    }
}
