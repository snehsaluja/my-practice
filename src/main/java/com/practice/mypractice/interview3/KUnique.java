package com.practice.mypractice.interview3;

import java.util.HashMap;
import java.util.Map;

public class KUnique {


    public static String KUniqueCharacters(String str) {
        int k = str.charAt(0) - 48, start = 1, end = 1, maxLen = 0, stIndex = 1, endIndex = 1;
        int charFreq[] = new int[26];
        //System.out.println("Entering");
        while (start < str.length()) {
            //System.out.println("start = " + start + "; end = " + end);
            while (end < str.length()) {
                char ch = str.charAt(end);
                charFreq[ch - 97]++;
                if (checkIfFreqGreaterThanK(charFreq, k)) {
                    end++;
                    break;
                } else {
                    if (end - start + 1 > maxLen) {
                        maxLen = end - start + 1;
                        stIndex = start;
                        endIndex = end;
                    }
                    end++;
                }
            }

            while (start < end) {
                char ch = str.charAt(start);
                charFreq[ch - 97]--;
                if (!checkIfFreqGreaterThanK(charFreq, k)) {
                    start++;
                    break;
                }
                start++;
            }
            /*if(start >= str.length()){
                break;
            }*/

        }
        return str.substring(stIndex, endIndex + 1);
    }

    private static boolean checkIfFreqGreaterThanK(int[] charFreq, int k) {
        int countUnique = 0;
        for (int i = 0; i < charFreq.length; i++) {
            if (charFreq[i] > 0) {
                countUnique++;
            }
            if (countUnique > k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(KUniqueCharacters("2aabbacbaa"));
        System.out.println(KUniqueCharacters("3abacbebebe"));
        System.out.println(KUniqueCharacters("2aeczbbcbbb"));
        System.out.println(KUniqueCharacters("1a"));

    }

    // code from youtube:
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        char[] arr = s.toCharArray();
        int left = 0, right = 0, n = arr.length;
        int longestLen = 0;

        while(right < n){
            //Expand the window
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            //Shrink the window if window size exceeds the k distinct characters
            while(k < map.size()){
                if(map.get(arr[left]) == 1){
                    map.remove(arr[left]);
                }else{
                    map.put(arr[left], map.get(arr[left]) - 1);
                }
                left++;
            }

            //Update the longest length
            longestLen = Math.max(longestLen, right - left + 1);

            right++;
        }

        return longestLen;
    }
}
/*
    aabba
            cbebebe
    bbcbbb
            a


    Have the function KUniqueCharacters(str) take the str parameter being passed
    and find the longest substring that contains k unique characters, where k will be the first character from the string. The substring will start from the second position in the string because the first character will be the integer k. For example: if str is "2aabbacbaa" there are several substrings that all contain 2 unique characters, namely: ["aabba", "ac", "cb", "ba"], but your program should return "aabba" because it is the longest substring.
        If there are multiple longest substrings, then return the first substring encountered with the longest length. k will range from 1 to 6.

        a) Count of each Character present in longest substring
        b) Can we compress it by n=1.


 */