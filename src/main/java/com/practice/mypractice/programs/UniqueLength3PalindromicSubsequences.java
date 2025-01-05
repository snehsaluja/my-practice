package com.practice.mypractice.programs;

import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueLength3PalindromicSubsequences {

    public static int countPalindromicSubsequence2(String s) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (Character ch : s.toCharArray()) {
            set.add(ch);
        }

        for (Character ch : set) {
            int startIndex = s.indexOf(ch);
            int endIndex = s.lastIndexOf(ch);
            if (startIndex < endIndex + 1) {
                Set<Character> uniqueSubSeqChars = new HashSet<>();
                for (int i = startIndex + 1; i < endIndex; i++) {
                    uniqueSubSeqChars.add(s.charAt(i));
                }
                count += uniqueSubSeqChars.size();
            }
        }
        return count;
    }

    public int countPalindromicSubsequence(String s) {
        int count = 0, n = s.length();
        Map<Character, int[]> charMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int start, end = -1;
            char ch = s.charAt(i);
            if (charMap.containsKey(ch)) {
                int[] pair = charMap.get(ch);
                start = pair[0];
                end = i;
            } else {
                start = i;
                end = i;
            }
            charMap.put(ch, new int[]{start, end});
        }

        for (Map.Entry<Character, int[]> entry : charMap.entrySet()) {
            char ch = entry.getKey();
            int[] pair = entry.getValue();
            int start = pair[0], end = pair[1];
            if (pair[1] - pair[0] == 1) {
                continue;
            }
            Set<Character> set = new HashSet<>();
            for (int i = start + 1; i <= end - 1; i++) {
                set.add(s.charAt(i));
            }
            count += set.size();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence2("aabca"));
        System.out.println(countPalindromicSubsequence2("adc"));
        System.out.println(countPalindromicSubsequence2("bbcbaba"));
    }
}
