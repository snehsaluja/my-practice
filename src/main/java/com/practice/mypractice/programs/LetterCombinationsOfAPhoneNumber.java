package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Integer, List<Character>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        map.put(2, List.of('a', 'b', 'c'));
        map.put(3, List.of('d', 'e', 'f'));
        map.put(4, List.of('g', 'h', 'i'));
        map.put(5, List.of('j', 'k', 'l'));
        map.put(6, List.of('m', 'n', 'o'));
        map.put(7, List.of('p', 'q', 'r', 's'));
        map.put(8, List.of('t', 'u', 'v'));
        map.put(9, List.of('w', 'x', 'y', 'z'));

        generateCombinations(digits, 0, map, list, new StringBuilder());

        return list;
    }

    private void generateCombinations(String digits, int i, Map<Integer, List<Character>> map, List<String> list, StringBuilder currStr) {
        if (i == digits.length()) {
            list.add(currStr.toString());
            return;
        }
        int currDigit = digits.charAt(i) - '0';
        for (char ch : map.get(currDigit)) {
            currStr.append(ch);
            generateCombinations(digits, i + 1, map, list, currStr);
            currStr.deleteCharAt(currStr.length() - 1);
        }
    }

    // ******************************** another way of storing numpad in hashmap **************************************

    public List<String> letterCombinations2(String digits) {
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

        generateCombinations2(digits, 0, map, list, new StringBuilder());

        return list;
    }

    private void generateCombinations2(String digits, int i, Map<Character, String> map, List<String> list, StringBuilder currStr) {
        if (i == digits.length()) {
            list.add(currStr.toString());
            return;
        }
        char currDigit = digits.charAt(i);
        for (char ch : map.get(currDigit).toCharArray()) {
            currStr.append(ch);
            generateCombinations2(digits, i + 1, map, list, currStr);
            currStr.deleteCharAt(currStr.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber ob = new LetterCombinationsOfAPhoneNumber();
        System.out.println(ob.letterCombinations("234"));
    }
}
