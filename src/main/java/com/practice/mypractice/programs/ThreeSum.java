package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];
                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return result;
    }

    //Time Limit Exceeded
    public List<List<Integer>> threeSum_bad(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int target = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<int[]> list = map.getOrDefault(nums[i] + nums[j], new ArrayList<>());
                list.add(new int[]{i, j});
                map.put(nums[i] + nums[j], list);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            List<int[]> list = map.get(target - nums[i]);
            if (list == null)
                continue;
            for (int[] val : list) {
                if (val != null && val[0] != i && val[1] != i) {
                    List<Integer> res = Arrays.asList(nums[val[0]], nums[val[1]], nums[i]);
                    Collections.sort(res);
                    result.add(res);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {

    }
}
