package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class NumberContainers {

    Map<Integer, Integer> container;
    Map<Integer, TreeSet<Integer>> numberIndex;

    public NumberContainers() {
        container = new HashMap<>();
        numberIndex = new HashMap<>();
    }

    public void change(int index, int number) {
        if (container.containsKey(index)) {
            int oldNumber = container.get(index);
            numberIndex.get(oldNumber).remove(index);
        }
        container.put(index, number);
        numberIndex.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        return numberIndex.containsKey(number) && numberIndex.get(number).size() > 0 ? numberIndex.get(number).first() : -1;
    }
}
