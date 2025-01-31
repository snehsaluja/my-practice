package com.practice.mypractice.programs.dream11_leetcode;

public class FlipToAllOnes {
    public static int minFlips(String binaryString) {

        char[] arr = binaryString.toCharArray();
        boolean flipped = false;
        int flips = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] == '0' && !flipped) || (arr[i] == '1' && flipped)) {
                flips++;
                flipped = !flipped;
            }
        }
        return flips;
    }

    public static void main(String[] args) {
        String binaryString = "1100101";
        System.out.println("Minimum flips: " + minFlips(binaryString));
    }
}