package com.practice.mypractice.programs;

public class FindFirstPalindromicStringInTheArray {

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word))
                return word;
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        int st = 0, end = word.length() - 1;
        char[] cArr = word.toCharArray();
        while (st <= end) {
            if (cArr[st++] != cArr[end--]) {
                return false;
            }
        }
        return true;

        /*
        while (st <= end) {
            if (word.charAt(st) != word.charAt(end)) {
                return false;
            }
            st++;
            end--;
        }
        return true;
        */
    }

    public static void main(String[] args) {

    }
}
