package com.practice.mypractice.programs.greedy;

public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {

    }


    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                totalProfit += prices[i - 1] - buyPrice;
                buyPrice = prices[i];
            }
        }
        totalProfit += prices[prices.length - 1] - buyPrice;
        return totalProfit;
    }

}
