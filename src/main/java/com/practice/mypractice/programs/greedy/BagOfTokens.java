package com.practice.mypractice.programs.greedy;

import java.util.Arrays;

public class BagOfTokens {

    public static void main(String[] args) {

    }

    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0, left = 0, right = tokens.length - 1, maxScore = 0;
        Arrays.sort(tokens);
        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                score++;
                left++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                score--;
                power += tokens[right];
                right--;
            } else {
                break;
            }
        }
        return maxScore;
    }
}
