package com.practice.mypractice.programs.dp;

public class PalindromePartitioning2 {

    // Leet Code : 132

    public static void main(String[] args) {
        System.out.println(minCut("aab"));
        System.out.println(minCut("a"));
        System.out.println(minCut("ab"));
        System.out.println(minCut("aaaaabab"));
        System.out.println(minCut("abzzbaxyyxaaa"));
        System.out.println(minCut("abzzbabzzbax"));
    }

    public static int minCut(String s) {

        int len = s.length();
        int[] dp = new int[len + 1];
        char[] sChar = s.toCharArray();
        for (int i = 0; i <= len; i++) {
            dp[i] = i - 1;
        }
        for (int i = 0; i < len; i++) {

            for (int j = 0; (i + j < len && i - j >= 0) && (sChar[i + j] == sChar[i - j]); j++) {
                dp[i + j + 1] = Math.min(dp[i + j + 1], 1 + dp[i - j]);
            }
            for (int j = 1; (i + j < len && i - j + 1 >= 0) && (sChar[i + j] == sChar[i - j + 1]); j++) {
                dp[i + j + 1] = Math.min(dp[i + j + 1], 1 + dp[i - j + 1]);
            }
        }

        return dp[len];
    }

}
