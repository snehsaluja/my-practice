package com.practice.mypractice.programs;

import com.practice.mypractice.programs.basics.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatchingInAnArray {

    public List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet<>();
        Arrays.sort(words, (a, b) -> {
            return a.length() - b.length();
        });
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String t = words[j];
                if (t.contains(s)) {
                    result.add(s);
                    continue;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<String> stringMatching_anotherWay(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (int j = 0; j < words.length; j++) {
                if (j == i)
                    continue;
                String t = words[j];
                if (t.contains(s)) {
                    result.add(s);
                    break;
                }
            }
        }
        return result;
    }

    public List<String> stringMatching_anotherWay2(String[] words) {
        List<String> result = new ArrayList<>();
        String str = String.join(" ", words);
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (str.indexOf(s) != str.lastIndexOf(s)) {
                result.add(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
