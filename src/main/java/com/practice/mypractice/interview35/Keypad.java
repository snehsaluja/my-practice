package com.practice.mypractice.interview35;


// DREAM 11 - Round 1: Question 2
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Keypad {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        generateCombinations(digits, 0, map, list, new StringBuilder());

        return list;
    }

    private void generateCombinations(String digits, int i, Map<Character, String> map, List<String> list, StringBuilder currStr) {
        if (i == digits.length()) {
            list.add(currStr.toString());
            return;
        }
        char currDigit = digits.charAt(i);
        for (char ch : map.get(currDigit).toCharArray()) {
            currStr.append(ch);
            generateCombinations(digits, i + 1, map, list, currStr);
            currStr.deleteCharAt(currStr.length() - 1);
        }
    }

}
