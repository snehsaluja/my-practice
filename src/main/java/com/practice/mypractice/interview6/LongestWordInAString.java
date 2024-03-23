package com.practice.mypractice.interview6;

import java.util.Arrays;
import java.util.Comparator;

public class LongestWordInAString {

    // Find the longest Word in a given String/sentence using Java 8 features. Should not use manual loops.

    public static void main(String[] args) {

        String test = "Welcome to the EPAM Interview process";
        // O/P: Interview

        Comparator<String> comp = (str1, str2) -> {
            return str1.length() - str2.length();
        };
        System.out.println(Arrays.stream(test.split(" ")).max(comp).stream().findFirst().get());
        // this is better :
        System.out.println(Arrays.stream(test.split(" ")).max(comp).get());

    }
}
