package com.practice.mypractice.programs;

import java.util.Scanner;
import java.util.StringTokenizer;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String s = sc.nextLine();
        LongestPalindromeSubstring playWithStrings = new LongestPalindromeSubstring();
        String palindromeSubstring = playWithStrings.getLongestPalindromeSubstring(s);
        System.out.println("Longest Palindrome : \"" + palindromeSubstring +
                "\", with length = " + palindromeSubstring.length());

        System.out.print("Enter a Sentence: ");
        s = sc.nextLine();
        String palWord = playWithStrings.getLongestPalindromeWordFromAString(s);
        System.out.println("Longest Palindrome word in the sentence: \"" + palWord
                + "\", with length = " + palWord.length());
    }

    public String getLongestPalindromeWordFromAString(String str) {
        StringTokenizer st = new StringTokenizer(str, " ");
        int maxLen = 0;
        String longestPalWord = "";
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            String palWord = getLongestPalindromeSubstring(word);
            if (palWord.length() > maxLen) {
                maxLen = palWord.length();
                longestPalWord = palWord;
            }
        }
        return longestPalWord;
    }

    public String getLongestPalindromeSubstring(String str) {
        int maxLength = 0, startIndex = 0, endIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            // Even Length substring
            int lo = i - 1, hi = i;
            while (lo >= 0 && hi < str.length() && str.charAt(lo) == str.charAt(hi)) {
                if (hi - lo + 1 > maxLength) { // add this if you want to check for space: && str.charAt(lo) != ' '
                    startIndex = lo;
                    endIndex = hi;
                    maxLength = endIndex - startIndex + 1;
                }
                lo--;
                hi++;
            }

            // Odd Length substring
            lo = i - 1;
            hi = i + 1;
            while (lo >= 0 && hi < str.length() && str.charAt(lo) == str.charAt(hi)) {
                if (hi - lo + 1 > maxLength) { // add this if you want to check for space: && str.charAt(lo) != ' '
                    startIndex = lo;
                    endIndex = hi;
                    maxLength = endIndex - startIndex + 1;
                }
                lo--;
                hi++;
            }
        }

        return str.substring(startIndex, endIndex + 1);
        //.trim();
    }

}
