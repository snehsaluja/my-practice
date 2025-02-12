package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// This was better in terms of performance in Leetcode
public class NumberContainers2 {

    Map<Integer, Integer> container;
    Map<Integer, PriorityQueue<Integer>> numberIndex;

    public NumberContainers2() {
        container = new HashMap<>();
        numberIndex = new HashMap<>();
    }

    public void change(int index, int number) {
        if (container.containsKey(index)) {
            int oldNumber = container.get(index);
            if (oldNumber == number) return;
            numberIndex.get(oldNumber).remove(index);
        }
        container.put(index, number);
        numberIndex.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
    }

    public int find(int number) {
        return numberIndex.containsKey(number) && !numberIndex.get(number).isEmpty() ? numberIndex.get(number).peek() : -1;
    }
}
