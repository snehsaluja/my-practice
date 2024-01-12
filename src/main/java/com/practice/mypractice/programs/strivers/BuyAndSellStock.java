package com.practice.mypractice.programs.strivers;

public class BuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0, minNumber = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minNumber > maxProfit) {
                maxProfit = prices[i] - minNumber;
            }
            if (prices[i] < minNumber) {
                minNumber = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

    }
}
