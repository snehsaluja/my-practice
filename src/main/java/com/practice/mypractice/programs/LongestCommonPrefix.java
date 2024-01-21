package com.practice.mypractice.programs;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        StringBuilder res = new StringBuilder();
        outer:
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || ch != strs[j].charAt(i)) {
                    break outer;
                }
            }
            res.append(ch);
        }

        return res.toString();
    }

    public static void main(String[] args) {

    }
}
