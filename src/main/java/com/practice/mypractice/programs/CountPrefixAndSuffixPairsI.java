package com.practice.mypractice.programs;

public class CountPrefixAndSuffixPairsI {

    //Easy Problem

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isPrefixAndSuffix(String str1, String str2) {
        return (str2.startsWith(str1) && str2.endsWith(str1));
    }

    public static void main(String[] args) {
        System.out.println("ab".indexOf("abab"));
        System.out.println("ab".lastIndexOf("abab"));

        CountPrefixAndSuffixPairsI ob = new CountPrefixAndSuffixPairsI();
        System.out.println(ob.countPrefixSuffixPairs(new String[]{"abab", "ab"}));
    }
}
