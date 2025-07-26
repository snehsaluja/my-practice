package com.practice.mypractice.programs;

public class LongestCommonPrefix_Practice {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        outer:
        for (int j = 0; j < strs[0].length(); j++) {
            char ch = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= j || strs[i].charAt(j) != ch) {
                    break outer;
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public String longestCommonPrefix2(String[] strs) {
        String prefix = strs[0];
        int n = prefix.length();
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            while (!str.startsWith(prefix)) {
                n--;
                prefix = prefix.substring(0, n);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {

    }

}
