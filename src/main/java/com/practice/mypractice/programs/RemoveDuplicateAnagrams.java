package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateAnagrams {


    public List<String> funWithAnagrams(List<String> text) {
        Set<String> seenAnagrams = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (String word : text) {
            String sortedWord = sortString(word);
            if (!seenAnagrams.contains(sortedWord)) {
                seenAnagrams.add(sortedWord);
                result.add(word);
            }
        }
        Collections.sort(result);
        return result;
    }

    private String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("code", "doce", "ecod", "framer", "frame");
        RemoveDuplicateAnagrams ob = new RemoveDuplicateAnagrams();
        System.out.println(ob.funWithAnagrams(list));
        System.out.println(ob.funWithAnagrams(Arrays.asList("code", "doce", "ecod", "anagrams", "aaagmsrn")));
    }
}
