package com.practice.mypractice.programs;

public class DecodeWays {

    public int numDecodings(String s) {
        return fun(s, 0);
    }

    private int fun(String s, int index) {
        if (index == s.length()) {
            return 1;
        }
        if (index > s.length() || s.charAt(index) == '0') {
            return 0;
        }

        int twoCharVal = 0;
        if (index < s.length() - 1 && ((s.charAt(index) - 48) * 10 + s.charAt(index + 1) - 48 <= 26)) {
            twoCharVal = fun(s, index + 2);
        }
        return fun(s, index + 1) + twoCharVal;
    }

    // ============== Memo ================

    public int numDecodings_memo(String s) {
        Integer[] memo = new Integer[s.length()];
        return fun_memo(s, 0, memo);
    }

    private int fun_memo(String s, int index, Integer[] memo) {
        if (index == s.length()) {
            return 1;
        }
        if (index > s.length() || s.charAt(index) == '0') {
            return 0;
        }
        if (memo[index] != null)
            return memo[index];
        int twoCharVal = 0;
        if (index < s.length() - 1 && ((s.charAt(index) - 48) * 10 + s.charAt(index + 1) - 48 <= 26)) {
            twoCharVal = fun_memo(s, index + 2, memo);
        }
        memo[index] = fun_memo(s, index + 1, memo) + twoCharVal;
        return memo[index];
    }


    // ============== DP ================

    public int numDecodings_dp(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            dp[i] += dp[i + 1];
            if (i < s.length() - 1 && ((s.charAt(i) - 48) * 10 + s.charAt(i+1) - 48 <= 26)) {
                dp[i] += dp[i + 2];
            }
        }

        return dp[0];
    }

    private int fun_dp(String s, int index, Integer[] memo) {
        if (index == s.length()) {
            return 1;
        }
        if (index > s.length() || s.charAt(index) == '0') {
            return 0;
        }
        if (memo[index] != null)
            return memo[index];
        int twoCharVal = 0;
        if (index < s.length() - 1 && ((s.charAt(index) - 48) * 10 + s.charAt(index + 1) - 48 <= 26)) {
            twoCharVal = fun_memo(s, index + 2, memo);
        }
        memo[index] = fun_memo(s, index + 1, memo) + twoCharVal;
        return memo[index];
    }


    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        //System.out.println(d.numDecodings("226"));
        System.out.println(d.numDecodings("1112234"));
    }
}
