package com.practice.mypractice.programs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaximumMagnets {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(getMaxElement(list));

        String str="Hello World";
        boolean f = str.chars().distinct().count() == str.length();
        Set<Character> set = new HashSet<>();
        str.chars().map(c -> c * 2).filter(c -> !set.add((char) c)).distinct().sorted();
        MyFun m = (int i)-> i;
        Arrays.parallelSort(new int[]{1,2,3});
    }

    public static int getMaxElement(List<Integer> list) {
        return list.stream()
                .mapToInt(value -> value)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }
}

interface MyFun {
    int add(int i);
}