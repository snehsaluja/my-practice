package com.practice.mypractice.interview12;

/*
NinjaCart:

# Generate permutations of the string
        # Input: "abc"
        # Output: "abc", "acb", "bca", "bac", "cab", "cba"

Input = abcd:

abcd, abdc, acbd, acdb, adcb, adbc,

a___ ,
b___


*/

import java.util.HashSet;
import java.util.Set;

public class PermutationOfString {

    Set<String> output = new HashSet<>();
    int maxLen = 0;

    public static void main(String[] args) {
        PermutationOfString obj = new PermutationOfString();
        String s = "abc";
        obj.maxLen = s.length();
        /*Set<Character> originalChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            originalChars.add(s.charAt(i));
        }*/
        //obj.findPermutations(new char[s.length()], originalChars, 0, 0, new HashSet<Character>());
        obj.findPermutations(new char[s.length()], s.toCharArray(), 0, new HashSet<Character>());
        System.out.println(obj.output);
    }

    public void findPermutations(char[] charArr, Set<Character> originalChars, int len, int k, HashSet<Character> selectedCharacters) {
/*
        if (len == originalChars.size()) {
            set.add(new String(charArr));
        }

        for(char ch : originalChars) {
            if (!selectedCharacters.contains(ch)) {
                charArr[len] = ch;
                selectedCharacters.add(ch);
            }
            findPermutations(charArr, originalChars, len + 1, k + 1, selectedCharacters);
            selectedCharacters.remove(ch);
        }*/


    }


    public void findPermutations(char[] charArr, char[] originalStr, int len, HashSet<Character> selectedCharacters) {

        if (len == maxLen) {
            output.add(new String(charArr));
            return;
        }

        for (int i = 0; i < originalStr.length; i++) {
            if (!selectedCharacters.contains(originalStr[i])) {
                charArr[len] = originalStr[i];
                selectedCharacters.add(originalStr[i]);
            } else {
                continue;
            }
            System.out.println(selectedCharacters);
            findPermutations(charArr, originalStr, len + 1, selectedCharacters);
            selectedCharacters.remove(originalStr[i]);
            System.out.println(selectedCharacters);
        }


    }

}


// [, , , , , , , , , , , , , abcd, ]

// [    , adbc, bcad, acdc, bdcc, acdb, bcac, adbb, bdca, cabd, dbac, acdd, bdcb, bdda, ddba, caca, bcdc, bcdd, cdda, cbdd, dbab, cbda, dacb, caba, cbdb, dacc, dcca, acbd, bdac, ab  , abdd, addb, bdaa, abdc, acbc, bacd, cdba, dcab, cdbb, badc, bcda, dabc, dcba, badd, cdca, dcbb, daba,
//        cbad, cdab, adcc, cbab, abcd, adcb, cdaa, bacb, cadd, dbcc, dcaa, cadb, dbca, abc , dbcb]
