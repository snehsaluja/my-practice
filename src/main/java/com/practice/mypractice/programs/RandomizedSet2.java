package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet2 {

    private Random random = new Random();
    private final Map<Integer, Integer> map = new HashMap<>();
    private int[] valArr = new int[32];
    private int i = 0;

    public RandomizedSet2() {
    }

    public boolean insert(int val) {
        Integer added = map.putIfAbsent(val, i);
        if (added != null) {
            return false;
        }
        if (i >= valArr.length) {
            valArr = Arrays.copyOf(valArr, valArr.length * 2);
        }
        valArr[i++] = val;
        return true;
    }

    public boolean remove(int val) {
        Integer removedIdx = map.remove(val);
        if (removedIdx == null) {
            return false;
        }
        if (removedIdx < i - 1) {
            valArr[removedIdx] = valArr[i - 1];
            map.put(valArr[i - 1], removedIdx);
        }
        i--;
        return true;
    }

    public int getRandom() {
        return valArr[random.nextInt(i)];
    }
}
