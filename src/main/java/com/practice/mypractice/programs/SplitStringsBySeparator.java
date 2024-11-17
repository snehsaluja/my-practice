package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.List;

public class SplitStringsBySeparator {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            int start = 0, end = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == separator) {
                    end = i;
                    if (end > start) {
                        result.add(word.substring(start, end));
                    }
                    start = i + 1;
                }
            }
            if (start < word.length()) {
                result.add(word.substring(start));
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
