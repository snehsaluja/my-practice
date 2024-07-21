package com.practice.mypractice.programs;

public class StockMarketInvestment {

    public static void main(String[] args) {
        int saving = 250;
        int[] currentValue = {175, 133, 109, 210, 97};
        int[] futureValue = {200, 125, 128, 228, 133};

        int maxProfit = getMaxProfit(saving, currentValue, futureValue);
        System.out.println("Maximum profit that can be earned: " + maxProfit);
    }

    public static int getMaxProfit(int saving, int[] currentValue, int[] futureValue) {
        int n = currentValue.length;
        int[] profits = new int[n];
        for (int i = 0; i < n; i++) {
            profits[i] = futureValue[i] - currentValue[i];
        }

        int[][] dp = new int[n + 1][saving + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= saving; w++) {
                if (currentValue[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - currentValue[i - 1]] + profits[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][saving];
    }
}