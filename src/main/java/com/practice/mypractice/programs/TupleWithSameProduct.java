package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TupleWithSameProduct {

    public static void main(String[] args) {

    }

    public int tupleSameProduct(int[] nums) {
        int count = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prod = nums[i] * nums[j];
                count += map.getOrDefault(prod, 0) * 8;
                map.put(prod, map.getOrDefault(prod, 0) + 1);
                map.merge(prod, 1, (a, b) -> Integer.sum(a, b));
            }
        }

        return count;
    }

}
