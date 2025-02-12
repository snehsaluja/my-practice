package com.practice.mypractice.programs;

public class CheckIfOneStringSwapCanMakeStringsEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        int[] freq = new int[26];
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                freq[s1.charAt(i) - 'a']++;
                freq[s2.charAt(i) - 'a']--;
                if (count > 2) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return count == 2 || count == 0;
    }

    // No extra space required!
    public boolean areAlmostEqual2(String s1, String s2) {
        int count = 0;
        int x = 0, y = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;

                if (count == 1) {
                    x = i;
                } else if (count == 2) {
                    y = i;
                }
                if (count > 2) {
                    return false;
                }
            }
        }
        return s1.charAt(x) == s2.charAt(y) && s1.charAt(y) == s2.charAt(x);
    }

}
