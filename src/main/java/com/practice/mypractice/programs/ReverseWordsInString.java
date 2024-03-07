package com.practice.mypractice.programs;

import java.util.StringTokenizer;

public class ReverseWordsInString {

    public String reverseWords(String s) {

        StringTokenizer st = new StringTokenizer(s, " ");
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            sb.insert(0, st.nextToken() + " ");
        }

        return sb.toString().trim();
    }

    public static String reverseWordsOptimized(String s) {
        StringBuilder sb = new StringBuilder();
        String[] sArr = s.trim().split("\\s+");
        for (int i = sArr.length - 1; i >= 0; i--) {
            sb.append(sArr[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWordsOptimized(s));
        System.out.println(reverseWordsOptimized("  hello world  "));
    }
}
