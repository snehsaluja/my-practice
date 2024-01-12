package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

public class CountHomogenousStrings {

    public static int countHomogenous(String s) {

        Map<String, Integer> map = new HashMap<>();
        int start = 0, end = 0, len = s.length();
        String temp;
        while (start < len && end < len) {
            if (s.charAt(end) == s.charAt(start)) {
                temp = s.substring(start, end + 1);
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                end++;
            } else {
                start = end;
            }
        }
        if (start < len) {
            temp = s.substring(start, len);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        return map.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        System.out.println(countHomogenous("abbcccaa"));
    }
}
