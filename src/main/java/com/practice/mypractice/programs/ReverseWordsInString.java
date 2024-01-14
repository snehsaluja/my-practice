package com.practice.mypractice.programs;

import java.util.StringTokenizer;

public class ReverseWordsInString {

    public String reverseWords(String s) {

        StringTokenizer st = new StringTokenizer(s, " ");
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            sb.insert(0, st.nextToken()+" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {

    }
}
