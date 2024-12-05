package com.practice.mypractice.programs;

public class MakeStringASubsequenceUsingCyclicIncrements {

    public static void main(String[] args) {
        System.out.println(canMakeSubsequence("abc", "ad"));
        System.out.println(canMakeSubsequence("abz", "ad"));
    }

    public static boolean canMakeSubsequence(String str1, String str2) {
        boolean result = false;
        int fixed = 0;
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            boolean seqFound = false;
            int j;
            for (j = fixed; j < str1.length(); j++) {
                char aux = str1.charAt(j);
                //System.out.println((char) (97 + (aux - 'a' + 1) % 26));
                if (aux == ch || ch == (97 + (aux - 'a' + 1) % 26)) {
                    seqFound = true;
                    break;
                }
            }
            if (seqFound) {
                fixed = j + 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
