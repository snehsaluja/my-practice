package com.practice.mypractice.programs.dp;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length - 1];
        boolean[] isTravelDay = new boolean[maxDay + 1];
        int[] dp = new int[maxDay + 1];
        for (int day : days) {
            isTravelDay[day] = true;
        }
        dp[0] = 0;
        for (int i = 1; i <= maxDay; i++) {
            if (!isTravelDay[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = dp[i - 1] + costs[0];
            dp[i] = Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[i]);
            dp[i] = Math.min(dp[Math.max(0, i - 30)] + costs[2], dp[i]);
        }
        return dp[maxDay];
    }

    public static void main(String[] args) {

    }
}
