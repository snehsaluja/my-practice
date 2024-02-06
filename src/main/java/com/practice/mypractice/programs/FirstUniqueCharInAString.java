package com.practice.mypractice.programs;

public class FirstUniqueCharInAString {

    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (freq[ch - 'a'] == 1)
                return i;
        }
        return -1;
    }

    public int firstUniqCharAnotherApproach(String s) {
        // I personally didn't like this approach
        int res = Integer.MAX_VALUE;

        for (char c = 'a'; c <= 'z'; c++) {
            int firstIndex = s.indexOf(c);
            int lastIndex = s.lastIndexOf(c);
            if (lastIndex != -1 && firstIndex == lastIndex) {
                res = Math.min(res, firstIndex);
            }
        }

        return Integer.MAX_VALUE == res ? -1 : res;
    }

    public static void main(String[] args) {

    }
}
