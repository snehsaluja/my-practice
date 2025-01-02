package com.practice.mypractice.programs;

public class MaximumScoreAfterSplittingAString {

    public static int maxScore(String s) {
        int max = 0, left = 0, right;
        char[] chArr = s.toCharArray();
        int[] freq = new int[2];
        for (char ch : chArr) {
            freq[ch - '0']++;
        }
        right = freq[1];
        for (int i = 0; i < chArr.length - 1; i++) {
            if (chArr[i] == '0') {
                left++;
            } else {
                right--;
            }
            max = Math.max(max, left + right);
        }
        return max;
    }

    public static int maxScore_singleIteration(String s) {
        char[] chArr = s.toCharArray();
        int ones = 0, n = s.length();
        int currScoreOnLeft = (chArr[0] == '0') ? 1 : 0;
        int maxScoreOnLeft = currScoreOnLeft;
        for (int i = 1; i < chArr.length - 1; i++) {
            if (chArr[i] == '0') {
                currScoreOnLeft++;
            } else {
                currScoreOnLeft--;
                ones++;
            }
            maxScoreOnLeft = Math.max(maxScoreOnLeft, currScoreOnLeft);
        }
        ones += (chArr[n - 1] == '1') ? 1 : 0;
        return ones + maxScoreOnLeft;
    }

    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
    }
}
