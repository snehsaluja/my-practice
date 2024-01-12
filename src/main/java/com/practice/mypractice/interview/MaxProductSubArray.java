package com.practice.mypractice.interview;

import java.util.List;

import com.google.common.collect.Lists;

public class MaxProductSubArray {

    public static void main(String[] args) {

        System.out.println(getMaxProduct(Lists.newArrayList(-5, 2, 0)));
        System.out.println(getMaxProduct(Lists.newArrayList(2, 3, -2, 4)));
        System.out.println(getMaxProduct(Lists.newArrayList(2, 3, -2, 4)));
        System.out.println(getMaxProduct(Lists.newArrayList(-2, 0, -1)));
        System.out.println(getMaxProduct(Lists.newArrayList(-5, 2, 0)));
        System.out.println(getMaxProduct(Lists.newArrayList(-5, 2, 0)));
        System.out.println(getMaxProduct(Lists.newArrayList(-5, 2, 0)));

        System.out.println("SLIDING====");

        System.out.println(getMaxProductSlidingWindow(Lists.newArrayList(-5, 2, 0)));
        System.out.println(getMaxProductSlidingWindow(Lists.newArrayList(2, 3, -2, 4)));
        System.out.println(getMaxProductSlidingWindow(Lists.newArrayList(-2, 0, -1)));
        System.out.println(getMaxProductSlidingWindow(Lists.newArrayList(-2, 0, 0, -1, 1)));
        System.out.println(getMaxProductSlidingWindow(Lists.newArrayList(-1, 0, -2, 2)));

    }


    public static int getMaxProductSlidingWindow(List<Integer> nums) {

        int start = 0, end = 0, len = nums.size(), currentProd = 1, maxProd = Integer.MIN_VALUE, n;

        while (start < len && end < len) {
            while (end < len) {
                n = nums.get(end);
                if (n == 0) {
                    //currentProd = 1;
                    //start = end + 1;
                    if (0 > maxProd) {
                        maxProd = 0;
                    }
                    break;
                }
                currentProd *= n;
                if (currentProd > maxProd) {
                    maxProd = currentProd;
                }
                end++;
            }

            while (start < end - 1) {
                n = nums.get(start);
                if (n != 0) {
                    currentProd /= n;
                }
                if (currentProd > maxProd) {
                    maxProd = currentProd;
                }
                start++;
            }
            currentProd = 1;
            end++;
            start = end;
        }

        return maxProd;
    }

    public static int getMaxProduct(List<Integer> nums) {

        int currentProd = 1, maxProd = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            currentProd *= nums.get(i);
            if (currentProd == 0) {
                currentProd = 1;
            } else if (currentProd > maxProd) {
                maxProd = currentProd;
            }
        }

        currentProd = 1;
        for (int i = nums.size() - 1; i >= 0; i--) {
            currentProd *= nums.get(i);
            if (currentProd == 0) {
                currentProd = 1;
            } else if (currentProd > maxProd) {
                maxProd = currentProd;
            }
        }

        return maxProd;
    }
}
