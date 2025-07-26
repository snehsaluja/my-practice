package com.practice.mypractice.programs.trees;

public class UniqueBinarySearchTrees_96 {

    // ================= Recursion =================

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (numTrees(i - 1) * numTrees(n - i));
        }
        return sum;
    }

    // ================= Memoization =================

    public int numTrees_memo(int n) {
        int[] memo = new int[n + 1];
        memo[0] = memo[1] = 1;
        return rec(n, memo);
    }

    private int rec(int n, int[] memo) {
        if (memo[n] != 0)
            return memo[n];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (rec(i - 1, memo) * rec(n - i, memo));
        }
        memo[n] = sum;
        return sum;
    }

    // ================= DP =================

    public int numTrees_dp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) { // considering total number of nodes as "i"...
            int sum = 0;
            for (int j = 1; j <= i; j++) { // considering the root "j" if total number of nodes are "i"
                sum += dp[j - 1] * dp[n - j];
            }
            dp[i] = sum;
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }

}
