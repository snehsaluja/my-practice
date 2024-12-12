package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class FindLongestSpecialSubstringThatOccursThrice1 {

    public static int maximumLength(String s) {
        Map<String, Integer> freq = getFrequencyMap(s);
        System.out.println(freq);
        List<Map.Entry<String, Integer>> list = freq.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() >= 3).collect(Collectors.toList());

        int maxLen = -1;
        for (Map.Entry<String, Integer> entry : list) {
            maxLen = Math.max(maxLen, entry.getKey().length());
        }

        return maxLen;
    }

    private static Map<String, Integer> getFrequencyMap(String s) {
        int i = 0, n = s.length();
        char[] arr = s.toCharArray();
        Map<String, Integer> freq = new HashMap<>();
        //PriorityQueue<SubString> pq = new PriorityQueue<SubString>((o1, o2) -> o2.frequency - o1.frequency);
        while (i < n) {
            int j = i + 1;
            while (j < n && arr[j] == arr[i]) {
                String sub = s.substring(i, j);
                freq.put(sub, freq.getOrDefault(sub, 0) + 1);
                j++;
            }
            String sub = s.substring(i, j);
            freq.put(sub, freq.getOrDefault(sub, 0) + 1);
            i++;
        }
        return freq;
    }

    class SubString {
        String str;
        int frequency;
    }

    public static void main(String[] args) {
        System.out.println(maximumLength("aaaa"));
    }
}
