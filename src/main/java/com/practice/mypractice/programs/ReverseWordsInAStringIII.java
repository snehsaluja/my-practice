package com.practice.mypractice.programs;

public class ReverseWordsInAStringIII {
    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        int start = 0, end = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() + 1; i++) {
            if (i == s.length() || s.charAt(i) == ' ') {
                end = i;
                for (int j = end - 1; j >= start; j--) {
                    sb.append(s.charAt(j));
                }
                sb.append(' ');
                start = end + 1;
            }
        }
        return sb.toString().trim();
    }

    public String reverseWordsOptimized(String s) {
        int start = 0, end = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length + 1; i++) {
            if (i == arr.length || arr[i] == ' ') {
                end = i - 1;
                while (start < end) {
                    char temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    start++;
                    end--;
                }
                start = i + 1;
            }
        }
        return new String(arr);
    }


    private boolean isAlphabet(char ch) {
        return (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122);
    }
}
