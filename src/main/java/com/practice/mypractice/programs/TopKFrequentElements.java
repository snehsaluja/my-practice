package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {


    // T = O(n log n)
    // S = O(n)
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<NumberFreq> pq = new PriorityQueue<>((o1, o2) -> o2.freq - o1.freq);
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(new NumberFreq(entry.getKey(), entry.getValue()));
        }

        int[] ans = new int[k];
        int index = 0;
        for (int i = 0; i < k; i++) {
            ans[index++] = pq.poll().num;
        }
        return ans;
    }

    class NumberFreq {
        int num;
        int freq;

        public NumberFreq(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    // =========================================================================================================

    // T = O(n)
    // S = O(n)

    public int[] topKFrequent_Optimized(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freqArr = new List[nums.length + 1];
        /*for (int i = 0; i < freqArr.length; i++) {
            freqArr[i] = new ArrayList<>();
        }*/
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freqIndex = entry.getValue();
            if (freqArr[freqIndex] == null) {
                freqArr[freqIndex] = new ArrayList<>();
            }
            freqArr[freqIndex].add(entry.getKey());
        }
        int index = k - 1;
        for (int i = freqArr.length - 1; i > 0; i--) {
            if (freqArr[i] != null) {
                int j = 0;
                while (j < freqArr[i].size() && index >= 0)
                    ans[index--] = freqArr[i].get(j++);
            }
        }
        return ans;
    }

    public int[] topKFrequent_Optimized2(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freqArr = new List[nums.length + 1];
        for (int i = 0; i < freqArr.length; i++) {
            freqArr[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freqArr[entry.getValue()].add(entry.getKey());
        }
        int index = k - 1;
        for (int i = freqArr.length - 1; i > 0; i--) {
            int j = 0;
            while (j < freqArr[i].size() && index >= 0)
                ans[index--] = freqArr[i].get(j++);

        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
