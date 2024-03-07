package com.practice.mypractice.programs.ubs.hackerranktest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class ProductSuggestions {

    public static void main(String[] args) {
        List<String> products = Lists.newArrayList("camera", "coconut", "car", "cart", "crate");
        System.out.println(getProductSuggestions(products, "camera"));
    }

    public static List<List<String>> getProductSuggestions(List<String> products, String search) {
        List<List<String>> suggestions = new ArrayList<>();

        for (int i = 0; i < search.length(); i++) {
            String temp = search.substring(0, i + 1);
            List<String> currentSuggestions = products.stream()
                    .filter(s -> s.startsWith(temp))
                    .sorted()
                    .limit(3)
                    .collect(Collectors.toList());
            suggestions.add(currentSuggestions);
        }
        return suggestions;
    }
}
