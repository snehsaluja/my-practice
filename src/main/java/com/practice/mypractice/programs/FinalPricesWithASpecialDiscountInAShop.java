package com.practice.mypractice.programs;

import java.util.Stack;

public class FinalPricesWithASpecialDiscountInAShop {


    // With Stacks -> T = O(n), Space = O(n)
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = prices[i] - stack.peek();
            } else {
                result[i] = prices[i];
            }
            stack.push(prices[i]);
        }

        return result;
    }


    // With Nested Loops -> T = O(n^2), Space = O(1)
    public int[] finalPrices2(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            getDiscount(prices, i);
        }
        return prices;
    }

    private static void getDiscount(int[] prices, int i) {
        for (int j = i + 1; j < prices.length; j++) {
            if (prices[j] <= prices[i]) {
                prices[i] = prices[i] - prices[j];
                break;
            }
        }
    }

    public static void main(String[] args) {

    }
}
