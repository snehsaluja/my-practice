package com.practice.mypractice.programs;

public class LongestPalindromeSubstring2 {

    public static void main(String[] args) {
        LongestPalindromeSubstring2 stringFunObj = new LongestPalindromeSubstring2();
        System.out.println(stringFunObj.getLongestPalindromeSubstring("hellohehehehopouywe"));
    }

    public String getLongestPalindromeSubstring(String str) {
        int len = str.length(), start = 0, end = 0, low, high, maxLength = 0;
        for (int i = 0; i < len; i++) {
            // for even length
            high = i;
            low = i - 1;
            while (high < len && low >= 0 && str.charAt(high) == str.charAt(low)) {
                if (high - low + 1 > maxLength) {
                    maxLength = high - low + 1;
                    start = low;
                    end = high;
                }
                high++;
                low--;
            }

            // for odd length
            high = i + 1;
            low = i - 1;
            while (high < len && low >= 0 && str.charAt(high) == str.charAt(low)) {
                if (high - low + 1 > maxLength) {
                    maxLength = high - low + 1;
                    start = low;
                    end = high;
                }
                high++;
                low--;
            }
        }
        return str.substring(start, end + 1);
    }

}
