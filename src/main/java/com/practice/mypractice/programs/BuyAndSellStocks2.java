package com.practice.mypractice.programs;

public class BuyAndSellStocks2 {
    public int maxProfit(int[] prices) {
        int totalProfit = 0, current = 0, start = prices[0], end;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                start = prices[i];
            } else if (prices[i] > start) {
                totalProfit += (prices[i] - prices[i - 1]);
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {

    }
}
