package com.practice.mypractice.programs;

public class FirstBadVersion {
    public int firstBadVersion(int n) {

        int start = 1, end = n, mid = 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                if (!isBadVersion(mid - 1)) {
                    return mid;
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }

    public static void main(String[] args) {
        int low = 40, high = 55, mid = (low + high) / 2;
        System.out.println(mid);
        System.out.println(low + (high-low)/2);
    }
}
