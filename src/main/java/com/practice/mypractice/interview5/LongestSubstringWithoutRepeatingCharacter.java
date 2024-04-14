package com.practice.mypractice.interview5;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {

    // Oracle Interview:

    // length of longest substring - without repeating character
    // "abcdef"de - abcdef
    // "abcxyvsz"stuv - abcxyvsz
    // ab"abcxyvsz"stuv - abcxyvsz


    public static String longestSubstring(String str) {

        int[] freq = new int[26];
        int stIdx = 0, endIdx = 0, maxLen = 0, len = str.length(), start = 0, end = 0;

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
            end = i;
            if (isFreqUnique(freq)) {
                if (maxLen < (end - start + 1)) {
                    maxLen = end - start + 1;
                    stIdx = start;
                    endIdx = end;
                }
            } else {
                while (start < end) {
                    freq[str.charAt(start) - 'a']--;
                    start++;
                    if (isFreqUnique(freq)) {
                        break;
                    }
                }
            }
        }
        return str.substring(stIdx, endIdx + 1);
    }

    private static boolean isFreqUnique(int[] freq) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 1) {
                return false;
            }
        }
        return true;
    }


    public static String longestSubstring2(String str) {
        int len = str.length(), max = 0, start = 0, startIndex = 0, endIndex = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            while (freqMap.get(ch) > 1) {
                char startCh = str.charAt(start);
                freqMap.put(startCh, freqMap.get(startCh) - 1);
                start++;
            }
            if (i - start + 1 > max) {
                max = i - start + 1;
                startIndex = start;
                endIndex = i;
            }

        }
        return str.substring(startIndex, endIndex + 1);
    }


    public static void main(String[] args) {
        System.out.println(longestSubstring("abcdefde"));
        System.out.println(longestSubstring("abcxyvszstuv"));
        System.out.println(longestSubstring("ababcxyvszstuv"));
    }
}
