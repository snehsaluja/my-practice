package com.practice.mypractice.programs;

public class SubarrayProductLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0)
            return 0;
        int prod = 1, start = 0, count = 0, i;
        for (i = 0; i < nums.length; i++) {
            prod *= nums[i];
            if (prod >= k) {
                int diff = i - start;
                count += (diff * (diff + 1)) / 2;
                System.out.println(count);
                while (prod >= k && start < i) {
                    prod /= nums[start];
                    start++;
                }
                if (start != i) {
                    diff = i - start;
                    count -= (diff * (diff + 1)) / 2;
                    System.out.println("sub=" + count);
                }
            }
        }
        int diff = i - start;
        count += (diff * (diff + 1)) / 2;
        return count;
    }


    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int prod = 1, start = 0, count = 0, i;
        for (i = 0; i < nums.length; i++) {
            prod *= nums[i];
            while (prod >= k) {
                prod /= nums[start++];
            }
            count += 1 + (i - start);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("=>" + numSubarrayProductLessThanK2(new int[]{10, 5, 2, 6}, 100));
        System.out.println("====");
        System.out.println(numSubarrayProductLessThanK2(new int[]{10, 5, 2, 3, 2}, 100));
        System.out.println("====");
        System.out.println(numSubarrayProductLessThanK2(new int[]{1, 1, 1}, 1));
    }
}
