package com.practice.mypractice.programs;

public class CountVowelStringsInRanges {

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] vow = new int[words.length];
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                vow[i] = ++count;
            } else {
                vow[i] = count;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            int leftFreq = (l - 1 >= 0) ? vow[l - 1] : 0;
            int rightFreq = vow[r];
            ans[i] = rightFreq - leftFreq;
        }

        return ans;
    }

    public int[] vowelStrings2(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] vow = new int[words.length + 1];
        vow[0] = 0;
        for (int i = 0; i < words.length; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                vow[i + 1] = vow[i] + 1;
            } else {
                vow[i + 1] = vow[i];
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            ans[i] = vow[r + 1] - vow[l];
        }
        return ans;
    }

    private boolean isVowel(char c) {
        //return "aeiou".indexOf(c) > -1;
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {

    }

}
