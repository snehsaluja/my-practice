package com.practice.mypractice.interview20;

/*
Salesforce Hackerrank Question 2:


A palindrome is a string that reads the same forward and backward, e.g. 121 or tacocat.
A substring is a contiguous subset of characters in a string.
Given a string s, how many distinct substrings of s are palindromes?

Example
s = "mokkori"

Some of its substrings are [m, o, k, r, i, mo, ok, mok, okk, kk, okko].
There are 7 distinct palindromes [m, o, k, r, i, kk, okko].

Function Description
Complete the function palindrome in the editor below.
palindrome has the following parameter(s):
    strings: a string

Returns
    int: the number of distinct palindromes

Constraints
• 1 ≤ /5/ ≤ 5000
• Each character s[i] = ascii[a-z]

Input Format for Custom Testing
Input from stdin will be processed as follows and passed to the function.
The input line contains a string s.


______________________________________________________
Sample Input 0:
______________________________________________________
STDIN                       Function Parameters
-----                       -------------------
aabaa           →           s = "aabaa"
______________________________________________________
Sample Output 0:
______________________________________________________
5
______________________________________________________

Explanation:
Palindromic substrings are ['a', 'aa', 'aabaa', 'aba', 'b'].
The substring 'a' occurs 4 times, but is counted only once.
Similarly, the substring 'aa' occurs twice but counts as one distinct palindrome.
The number of distinct palindromes is 5.

______________________________________________________
Sample Input 1
______________________________________________________
STDIN                                   Function Parameters
-----                                   -------------------
abcddcbabcdcdaadcdcbabcdddcb        →   S = "abcddcbabcdcdaadcdcbabcdddcb"
______________________________________________________
Sample Output 1
______________________________________________________
27
______________________________________________________

Explanation:
Palindromic substrings are ['a', 'b', 'c, 'd', 'aa', 'dd', 'cddc,
'bab', 'cbabc', 'abcddcba', 'bcddcb, 'dcbabcd', 'cdc, 'dcd',
'ddd','cdddc','bcdddcb','daad', 'cdaadc', 'dcdaadcd',
'cdcdaadcdc', 'bcdcdaadcdcb', 'abcdcdaadcdcba,
'babcdcdaadcdcbab', 'cbabcdcdaadcdcbabc',
'dbabcacdaadcdcbabcd', 'ddcbabcdcdaadcdcbabcdd'].
The number of distinct palindromes is 27.

 */


import java.util.HashSet;
import java.util.Set;

public class PalindromeSubstringCount {
    public static void main(String[] args) {
        System.out.println(palindrome("aabaa"));
        System.out.println(palindrome("abcddcbabcdcdaadcdcbabcdddcb"));
        System.out.println(palindrome("madam"));
    }

    public static int palindrome(String s) {
        Set<String> set = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            //for even length palindrome substrings
            int high = i, low = i - 1;
            while (high < n && low >= 0 && s.charAt(high) == s.charAt(low)) {
                set.add(s.substring(low, high + 1));
                high++;
                low--;
            }

            //for odd length palindrome substrings
            high = i;
            low = i;
            while (high < n && low >= 0 && s.charAt(high) == s.charAt(low)) {
                set.add(s.substring(low, high + 1));
                high++;
                low--;
            }

        }
        return set.size();
    }

}
