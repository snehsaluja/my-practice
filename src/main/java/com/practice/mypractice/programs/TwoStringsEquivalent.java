package com.practice.mypractice.programs;

public class TwoStringsEquivalent {

    public static void main(String[] args) {

        String[] word1 = {"ab", "c"}, word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual2(word1, word2));
        System.out.println(arrayStringsAreEqual2(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
        System.out.println(arrayStringsAreEqual2(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
        System.out.println(arrayStringsAreEqual2(new String[]{"abc", "d"}, new String[]{"abcddefg"}));
        System.out.println(arrayStringsAreEqual2(new String[]{"abc", "d", "defg"}, new String[]{"abcdd"}));
    }

    public static boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();

        for (String str : word1) {
            sb1.append(str);
        }

        for (String str : word2) {
            sb2.append(str);
        }

        return (sb1.compareTo(sb2) == 0);
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        int arrayIdx1 = 0, arrayIdx2 = 0, strIdx1 = 0, strIdx2 = 0;
        String str1 = word1[0], str2 = word2[0];
        boolean word1Scanned = false, word2Scanned = false;

        while (true) {
            if (!(str1.charAt(strIdx1) == str2.charAt(strIdx2))) {
                return false;
            }
            strIdx1++;
            strIdx2++;
            if (strIdx1 == str1.length()) {
                strIdx1 = 0;
                arrayIdx1++;
                if (arrayIdx1 < word1.length) {
                    str1 = word1[arrayIdx1];
                } else {
                    word1Scanned = true;
                }
            }
            if (strIdx2 == str2.length()) {
                strIdx2 = 0;
                arrayIdx2++;
                if (arrayIdx2 < word2.length) {
                    str2 = word2[arrayIdx2];
                } else {
                    word2Scanned = true;
                }
            }

            if (word1Scanned && word2Scanned) {
                break;
            } else if ((word1Scanned && !word2Scanned) || (!word1Scanned && word2Scanned)) {
                return false;
            }
        }
        return true;
    }


}
