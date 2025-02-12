package com.practice.mypractice.programs;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int sum = 0, n = height.length;
        int maxLeft = 0, maxRight = 0, left = 0, right = n - 1;

        while (left <= right) {
            while (maxLeft <= maxRight && left <= right) {
                int water = (maxLeft - height[left]);
                sum += Math.max(water, 0);
                maxLeft = Math.max(maxLeft, height[left]);
                left++;
            }
            while (maxRight < maxLeft && left <= right) {
                int water = (maxRight - height[right]);
                sum += Math.max(water, 0);
                maxRight = Math.max(maxRight, height[right]);
                right--;
            }
        }
        return sum;
    }

    public static int trap3(int[] height) {
        int sum = 0, n = height.length, left = 0, right = n - 1;
        int maxLeft = height[left], maxRight = height[right];

        while (left < right) {
            if (maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                sum += (maxLeft - height[left]);
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                sum += (maxRight - height[right]);
            }
        }
        return sum;
    }

    public static int trap2(int[] height) {
        int sum = 0, n = height.length, max = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        for (int i = 0; i < n; i++) {
            leftMax[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            rightMax[i] = max;
            max = Math.max(max, height[i]);
        }

        for (int i = 0; i < n; i++) {
            int water = (Math.min(leftMax[i], rightMax[i]) - height[i]);
            sum += Math.max(water, 0);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}
