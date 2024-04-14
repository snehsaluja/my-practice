package com.practice.mypractice.programs;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        
        int n = nums.length, low = 0, high = n - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == n - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            } else {    // i.e. nums[mid] < nums[mid + 1]
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
