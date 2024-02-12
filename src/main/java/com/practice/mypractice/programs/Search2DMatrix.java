package com.practice.mypractice.programs;

public class Search2DMatrix {


    // I like this approach more
    public boolean searchMatrix(int[][] matrix, int target) {
        int low, high, mid;
        if (target < matrix[0][0]) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            low = 0;
            high = matrix[i].length;
            if (target > matrix[i][high - 1]) {
                continue;
            }
            while (low < high) {
                mid = (high + low) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (target > matrix[i][mid]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        return false;
    }


    // The below approach is ok-ok..
    public boolean searchMatrixAnotherApproach(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int mid_val = matrix[mid / n][mid % n];

            if (mid_val == target)
                return true;
            else if (mid_val < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
