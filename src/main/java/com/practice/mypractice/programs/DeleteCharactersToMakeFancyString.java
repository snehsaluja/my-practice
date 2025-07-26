package com.practice.mypractice.programs;

public class DeleteCharactersToMakeFancyString {

    public static void main(String[] args) {

    }

    public String makeFancyString(String s) {
        char prev = s.charAt(0);
        int currCount = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(prev);
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == prev) {
                currCount++;
            } else {
                prev = curr;
                currCount = 1;
            }
            if (currCount < 3) {
                sb.append(curr);
            }
        }
        return sb.toString();
    }

    public String makeFancyString_Optimized(String s) {
        char[] arr = s.toCharArray();
        char prev = arr[0];
        int currCount = 1, k = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == prev) {
                currCount++;
            } else {
                prev = arr[i];
                currCount = 1;
            }
            if (currCount < 3) {
                arr[k++] = arr[i];
            }
        }
        return new String(arr, 0, k);
    }


}
