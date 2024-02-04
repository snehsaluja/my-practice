package com.practice.mypractice.programs.dto;

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

    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("a", "aa"));
    }
}
