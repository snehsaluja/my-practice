package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE, startIdx = 0, endIdx = 0, st = 0;
        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            while (allCharsIncluded(sMap, tMap)) {
                if (i - st + 1 < minLen) {
                    startIdx = st;
                    endIdx = i + 1;
                    minLen = i - st + 1;
                }
                char removeCh = s.charAt(st);
                sMap.put(removeCh, sMap.get(removeCh) - 1);
                st++;
            }
        }

        return s.substring(startIdx, endIdx);
    }

    private boolean allCharsIncluded(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            char tChar = entry.getKey();
            int tFreq = entry.getValue();
            if (sMap.getOrDefault(tChar, 0) < tFreq) {
                return false;
            }
        }
        return true;
    }

    public String minWindowOptimized(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        int[] map = new int[128];
        int count = t.length(), start = 0, end = 0, startIdx = 0, endIdx = 0, minLen = Integer.MAX_VALUE;
        for (char ch : t.toCharArray()) {
            map[ch]++;
        }

        char[] sArr = s.toCharArray();

        while (end < s.length()) {
            if (map[sArr[end++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    minLen = end - start;
                    startIdx = start;
                    endIdx = end;
                }
                if (map[sArr[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(startIdx, endIdx + 1);
    }


    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("a", "aa"));

        System.out.println(obj.minWindowOptimized("a", "aa"));


    }
}
