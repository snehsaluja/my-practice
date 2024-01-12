package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskScheduling {

    public static void main(String[] args) {
        List<Integer> taskMemory = Arrays.asList(17, 18, 13, 11, 13, 19, 15, 13, 10, 13, 12, 11, 15, 19, 16, 10, 11, 14, 18, 19);
        List<Integer> taskType = Arrays.asList(4, 3, 4, 1, 1, 3, 3, 4, 2, 2, 4, 3, 5, 1, 3, 4, 3, 2, 3, 1);
        int maxMemory = 213;
        System.out.println(getMinTime(taskMemory, taskType, maxMemory));
    }


    public static int getMinTime(List<Integer> task_memory, List<Integer> task_type, int max_memory) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = task_type.size();
        int count = 0, temp;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(task_type.get(i))) {
                temp = map.get(task_type.get(i)) + task_memory.get(i);
                if (temp > max_memory) {
                    count += 2;
                } else {
                    count++;
                }
                map.remove(task_type.get(i));
            } else {
                map.put(task_type.get(i), task_memory.get(i));
            }
        }
        count += map.size();
        return count;
    }
}
