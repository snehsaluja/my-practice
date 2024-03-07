package com.practice.mypractice.programs;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {

    public static void main(String[] args) {
        System.out.println(minimumLength("cabaabac"));
        System.out.println(minimumLength("ca"));
        System.out.println(minimumLength("aabccabba"));
        System.out.println(minimumLength("bbbbbbbbbbbbbbbbbbb"));
    }

    public static int minimumLength(String s) {

        int len = s.length(), right = len - 1, left = 0;
        char[] sArr = s.toCharArray();
        while (left < right) {
            if (sArr[left] == sArr[right]) {
                char ch = sArr[left];
                while (sArr[left] == ch && left < right) {
                    left++;
                }
                while (sArr[right] == ch && left <= right) {
                    right--;
                }
            } else {
                break;
            }
        }
        return (right < left) ? 0 : right - left + 1;
    }
}
