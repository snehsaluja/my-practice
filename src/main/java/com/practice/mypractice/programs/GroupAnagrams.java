package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    ////////////////////////////////////////////////////////////////
    // 3rd method:
    ////////////////////////////////////////////////////////////////

    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            map.computeIfAbsent(sortedStr, s1 -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());

    }

    ////////////////////////////////////////////////////////////////
    // 1st method:
    ////////////////////////////////////////////////////////////////

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String freq = calculateFreqString(s);
            List<String> list = map.getOrDefault(freq, new ArrayList<>());
            list.add(s);
            map.put(freq, list);
        }
        return new ArrayList<>(map.values());
    }

    private String calculateFreqString(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder con = new StringBuilder();
        for (int i : freq) {
            con.append(i);
            con.append(",");
        }
        return con.toString();
    }

    ////////////////////////////////////////////////////////////////
    // 2nd method:
    ////////////////////////////////////////////////////////////////

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String freq = calculateFreqString2(s);
            List<String> list = map.getOrDefault(freq, new ArrayList<>());
            list.add(s);
            map.put(freq, list);
        }
        return new ArrayList<>(map.values());
    }

    private String calculateFreqString2(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder con = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            con.append('a' + i);
            con.append(freq[i]);
        }
        return con.toString();
    }

    ////////////////////////////////////////////////////////////////
    // 4th method:
    ////////////////////////////////////////////////////////////////

    public List<List<String>> groupAnagrams4(String[] strs)  {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] count = new char[26];
            for (int j = 0; j < strs[i].length(); j++) {
                char c = strs[i].charAt(j);
                count[c - 'a']++;
            }
            String str = new String(count);
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    ////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        GroupAnagrams ob = new GroupAnagrams();
        System.out.println(ob.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(ob.groupAnagrams(new String[]{"bdddddddddd", "bbbbbbbbbbc"}));
    }
}


// bdddddddddd
// 01010
// bbbbbbbbbbc
// 01010