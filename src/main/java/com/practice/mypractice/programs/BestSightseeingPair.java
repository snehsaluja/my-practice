package com.practice.mypractice.programs;

public class BestSightseeingPair {

    // score = arr[i] + arr[j] + i - j;
    //       = (arr[i] + i) + (arr[j] - j);

    public int maxScoreSightseeingPair(int[] values) {
        int max = Integer.MIN_VALUE, n = values.length;
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = values[n - 1] - (n - 1); // (arr[j] - j)
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(values[i] - i, suffixMax[i + 1]);
        }

        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, values[i] + i + suffixMax[i + 1]);
        }
        return max;
    }


    public int maxScoreSightseeingPair_AnotherWay(int[] values) {
        int max = values[0], n = values.length, ans = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, values[i] - i + max);
            /*if (values[i] - i + max > ans) {
                ans = values[i] - i + max;
            }*/
            max = Math.max(max, values[i] + i);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
