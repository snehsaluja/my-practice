package com.practice.mypractice.programs;

public class CountWaysToBuildGoodStrings {
    public static void main(String[] args) {

    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        return count(low, high, zero, one, 0);
    }

    public int count(int low, int high, int zero, int one, int currSum) {
        if (currSum > high)
            return 0;
        int add = 0;
        if (currSum >= low && currSum <= high) {
            add = 1;
        }
        return add + count(low, high, zero, one, currSum + zero) + count(low, high, zero, one, currSum + one);
    }

    public int countGoodStringsMemo(int low, int high, int zero, int one) {
        int MOD = 1000000007;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        for (int i = 0; i < high + 1; i++) {
            if (i + zero <= high) {
                dp[i + zero] = (dp[i + zero] + dp[i]) % MOD;
            }
            if (i + one <= high) {
                dp[i + one] = (dp[i + one] + dp[i]) % MOD;
            }
        }
        int count = 0;
        for (int i = low; i <= high; i++) {
            count = (count + dp[i]) % MOD;
        }
        return count;
    }

    private int countMemo(int low, int high, int zero, int one, int currSum, int[] memo) {

        return 0;
    }


}
