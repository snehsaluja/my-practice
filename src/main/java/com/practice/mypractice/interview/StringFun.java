package com.practice.mypractice.interview;

import java.util.HashSet;

public class StringFun {

    public static void main(String[] args) {
        String str = "helloooommoooollmhixyzzz";
        StringFun stringFun = new StringFun();
        System.out.println("Longest Pal Str = " + stringFun.getLongestPalindromeSubstring(str));
        System.out.println("=========================");
        System.out.println(stringFun.getLongestNonRepeatingCharString(str));
    }

    public int getLongestNonRepeatingCharString(String str) {
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


    /*
    public int getLongestNonRepeatingCharString(String str) {
        if (str == null || str.length() == 0)
            return 0;
        if (str.length() == 1)
            return 1;
        int maxLength = 0, startIndex = 0;
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        set.add(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                if (i - startIndex > maxLength) {
                    maxLength = set.size();

                }
                set.clear();
                set.add(str.charAt(i));
                startIndex = i;
                count = 1;
            } else {
                set.add(str.charAt(i));
                count++;
                if (count > maxLength) {
                    maxLength = count;
                }
            }
        }
        //System.out.println(set.size());
        //System.out.println(maxLength);
        return maxLength;
    }*/

    public String getLongestPalindromeSubstring(String str) {

        int maxLength = 0, startIndex = 0, endIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            int lo = i - 1, hi = i;
            while (lo >= 0 && hi < str.length() && str.charAt(lo) == str.charAt(hi)) {
                if ((hi - lo + 1) > maxLength) {
                    startIndex = lo;
                    endIndex = hi;
                    maxLength = (hi - lo + 1);
                }
                lo--;
                hi++;
            }
            lo = i - 1;
            hi = i + 1;
            while (lo >= 0 && hi < str.length() && str.charAt(lo) == str.charAt(hi)) {
                if ((hi - lo + 1) > maxLength) {
                    startIndex = lo;
                    endIndex = hi;
                    maxLength = (hi - lo + 1);
                }
                lo--;
                hi++;
            }
        }
        return str.substring(startIndex, endIndex + 1);
    }
}

/*


for (int i = 0; i < str.length(); i++) {
        j = i + 1;
        if (j >= str.length())
        break;
        if (set.contains(str.charAt(j))) {
        if (j - i > maxLength) {
        startIndex = i;
        endIndex = j;
        maxLength = (j - i);
        }
        set.clear();
        i = j - 1;
        set.add(str.charAt(j));
        } else {
        set.add(str.charAt(j));
        }
        }*/
