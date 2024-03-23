package com.practice.mypractice.programs;

import java.util.HashSet;

// LeetCode :
// 3. Longest Substring Without Repeating Characters

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String str) {
        int max = 0, left = 0, len = str.length();
        int[] freq = new int[128];
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            freq[ch]++;
            if (freq[ch] == 1) {
                max = Math.max(max, i - left + 1);
            } else {
                while (freq[ch] != 1) {
                    freq[str.charAt(left)]--;
                    left++;
                }
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String str) {
        int len = str.length();
        int maxLength = 0, left = 0;
        HashSet<Character> set = new HashSet<>();
        for (int right = 0; right < len; right++) {

            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (set.contains(str.charAt(right))) {
                    set.remove(str.charAt(left));
                    left++;
                }
                set.add(str.charAt(right));
            }
        }
        return maxLength;
    }

}
