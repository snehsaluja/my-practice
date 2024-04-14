package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler2 {

    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        long count = 0;
        for (int num : tasks) {
            if (map.containsKey(num)) {
                count = Math.max(count, map.get(num) + space) + 1;
            } else {
                count++;
            }
            map.put(num, count);
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
