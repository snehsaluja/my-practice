package com.practice.mypractice.programs;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0, minNum = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minNum) {
                minNum = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minNum);
            }
        }
        return maxProfit;
    }
}
