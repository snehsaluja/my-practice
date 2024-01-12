package com.practice.mypractice.programs;

public class RotatedArrayFindMin {


    public static void main(String[] args) {

        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[]{0, 1, 2, 4, 5, 6, 7}));
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{11, 13, 15, 17}));
        System.out.println(findMin(new int[]{16, 17, 11, 13, 15}));
        System.out.println(findMin(new int[]{16, 15}));

    }

    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1, mid, min = Integer.MAX_VALUE;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] < min) {
                min = nums[mid];
            }
            if (/*nums[mid] < nums[low] ||*/ nums[mid] > nums[high]) {
                low = mid + 1;
            }
            if (/*nums[mid] > nums[low] ||*/ nums[mid] <= nums[high]) {
                high = mid - 1;
            }
        }
        return min;
    }
}
