package com.practice.mypractice.programs;

public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        int m = word1.length(), i = 0;
        int n = word2.length(), j = 0;
        int k = 0, len = m + n;
        boolean toggle = true;
        char[] output = new char[len];
        while (k < len) {
            if (toggle && i < m) {
                output[k++] = word1.charAt(i++);
            } else if (j < n) {
                output[k++] = word2.charAt(j++);
            }
            toggle = !toggle;
        }
        return new String(output);
    }

    public String mergeAlternately2(String word1, String word2) {
        int m = word1.length(), i = 0;
        int n = word2.length(), j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < m && j < n) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        if (i < m)
            sb.append(word1.substring(i));
        else if (j < n)
            sb.append(word2.substring(j));

        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
