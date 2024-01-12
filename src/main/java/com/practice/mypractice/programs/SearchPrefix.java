package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class SearchPrefix {

    public static List<List<String>> getProductSuggestions(List<String> products, String search) {

        List<List<String>> resultList = new ArrayList<>();
        for (int i = 0; i < search.length(); i++) {
            List<String> productSuggestionForPrefix = getProductsForPrefix(products, search.substring(0, i + 1));
            if (productSuggestionForPrefix.size() != 0) {
                resultList.add(productSuggestionForPrefix);
            }
        }
        return resultList;
    }

    private static List<String> getProductsForPrefix(List<String> products, String prefix) {
        List<String> productSuggestionForPrefix = new ArrayList<>();
        int len = prefix.length();
        for (String product : products) {
            if (product.length() >= len && product.substring(0, len).equals(prefix)) {
                productSuggestionForPrefix.add(product);
            }
        }
        Collections.sort(productSuggestionForPrefix);
        return productSuggestionForPrefix.stream().limit(3).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(getProductSuggestions(Lists.newArrayList("abcd", "abdc", "abaa", "acbd"), "abad"));
        System.out.println(getProductSuggestions(Lists.newArrayList("abcd", "adbc", "abaa", "acbd"), "pqrs"));
        System.out.println(getProductSuggestions(Lists.newArrayList("carpet", "cart", "car", "camera", "crate"), "camera"));
        System.out.println(getProductSuggestions(Lists.newArrayList("carpet", "cart", "car", "camera", "crate", "caza", "camariya"), "camera"));
    }

}
