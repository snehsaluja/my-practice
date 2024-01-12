package com.practice.mypractice.programs;

import java.util.HashSet;
import java.util.Set;

public class CountPalindromicSubsequences {

    public static int countPalindromicSubsequence(String s) {
        Set<Character> allCharsInS = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            allCharsInS.add(s.charAt(i));
        }

        int sum = 0;
        for (char ch : allCharsInS) {
            int startIndex = s.indexOf(ch);
            int endIndex = s.lastIndexOf(ch);
            if (startIndex < endIndex) {
                Set<Character> uniqueSubSeqChars = new HashSet<>();
                for (int i = startIndex + 1; i < endIndex; i++) {
                    uniqueSubSeqChars.add(s.charAt(i));
                }
                sum += uniqueSubSeqChars.size();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
        System.out.println(countPalindromicSubsequence("adc"));
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }
}
