package com.practice.mypractice.programs;

import java.util.HashSet;
import java.util.Set;

public class RandomizedSet {

    private final Set<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (set.contains(val)) {
            return set.remove(val);
        }
        return false;
    }

    public int getRandom() {
        int random = ((int) (Math.random() * 100)) % set.size() + 1;
        int i = 1;
        for (int s : set) {
            if (i == random)
                return s;
            i++;
        }
        return 0;
    }
}
