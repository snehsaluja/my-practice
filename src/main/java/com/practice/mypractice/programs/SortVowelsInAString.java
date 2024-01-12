package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.checkerframework.checker.nullness.qual.Nullable;

public class SortVowelsInAString {

    public static String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        List<Integer> vowelIndexes = new ArrayList<>();

        char[] result = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                vowels.add(ch);
                vowelIndexes.add(i);
            }
        }
        Collections.sort(vowels);
        for (int i = 0; i < vowels.size(); i++) {
            result[vowelIndexes.get(i)] = vowels.get(i);
        }
        return new String(result);
    }

    public static String sortVowelsLessMemoryMoreTime(String s) {
        List<Character> vowels = new ArrayList<>();
        Set<Character> setOfVowels = Sets.newHashSet('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (setOfVowels.contains(ch)) {
                vowels.add(ch);
            }
        }
        Collections.sort(vowels);
        StringBuilder result = new StringBuilder(s);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (setOfVowels.contains(ch)) {
                result.replace(i, i + 1, String.valueOf(vowels.get(j++)));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortVowels("lEetcOde"));
        System.out.println(sortVowels("lYmpH"));
        System.out.println(sortVowelsLessMemoryMoreTime("lEetcOde"));
        System.out.println(sortVowelsLessMemoryMoreTime("lYmpH"));
    }

}
