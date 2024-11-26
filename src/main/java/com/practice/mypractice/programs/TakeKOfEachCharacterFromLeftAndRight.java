package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

public class TakeKOfEachCharacterFromLeftAndRight {


    // aabaaaacaabc
    // aabaabaacaabc

    public int takeCharacters(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int[] freq = new int[3];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        if (Math.min(freq[0], Math.min(freq[1], freq[2])) < k)
            return -1;

        int res = Integer.MAX_VALUE, l = 0;
        for (int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'a']--;

            while (Math.min(freq[0], Math.min(freq[1], freq[2])) < k) {
                freq[s.charAt(r) - 'a']++;
                l++;
            }
            res = Math.min(res, s.length() - (r - l + 1));
        }
        return res;
    }

}
