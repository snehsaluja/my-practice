package com.practice.mypractice.programs.weeklycontest.wc374;

import java.util.HashSet;
import java.util.Set;

public class CountTheCompleteSubstring {

    public int countCompleteSubstrings(String word, int k) {

        //int totalCharCount[] = new int[26];
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (char ch : word.toCharArray()) {
            //totalCharCount[ch - 'a']++;
            set.add(ch);
        }

        for (char ch : set) {
            int[] currIdx = new int[word.length()];
            int currCount = 0, j = 0, arrayStartIdx = 0, wordStartIdx = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == ch) {
                    currCount++;
                    currIdx[j++] = i;
                    if (currCount == k && checkGaps(currIdx, arrayStartIdx, j)) {
                        count++;
                        wordStartIdx++;
                        arrayStartIdx++;
                    }
                }
            }
        }
        return count;
    }

    private boolean checkGaps(int[] currIdx, int startIdx, int endIdx) {
        for (int i = startIdx; i < endIdx - 1; i++) {
            if (currIdx[i + 1] - currIdx[i] > 2)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /*"igigee"
        2
        "aaabbbccc"
        3*/

    }
}



/*
* 100145. Count Complete Substrings
User Accepted:121
User Tried:1040
Total Accepted:122
Total Submissions:2131
Difficulty:Medium
You are given a string word and an integer k.

A substring s of word is complete if:

Each character in s occurs exactly k times.
The difference between two adjacent characters is at most 2. That is, for any two adjacent characters c1 and c2 in s, the absolute difference in their positions in the alphabet is at most 2.
Return the number of complete substrings of word.

A substring is a non-empty contiguous sequence of characters in a string.



Example 1:

Input: word = "igigee", k = 2
Output: 3
Explanation: The complete substrings where each character appears exactly twice and the difference between adjacent characters is at most 2 are: igigee, igigee, igigee.
Example 2:

Input: word = "aaabbbccc", k = 3
Output: 6
Explanation: The complete substrings where each character appears exactly three times and the difference between adjacent characters is at most 2 are: aaabbbccc, aaabbbccc, aaabbbccc, aaabbbccc, aaabbbccc, aaabbbccc.


Constraints:

1 <= word.length <= 105
word consists only of lowercase English letters.
1 <= k <= word.length
*
* */