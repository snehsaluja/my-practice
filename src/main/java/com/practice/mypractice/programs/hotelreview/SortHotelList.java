package com.practice.mypractice.programs.hotelreview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SortHotelList {

    public List<Integer> sortHotels(String words, String[][] hotelReviews) {
        Set<String> dictionary = new HashSet<>(Arrays.asList(words.split(" ")));
        Map<Integer, Integer> hotelMap = new HashMap<>();
        List<Map.Entry<Integer, Integer>> hotelList;

        for (int i = 0; i < hotelReviews.length; i++) {
            int id = Integer.parseInt(hotelReviews[i][0]);
            String review = hotelReviews[i][1];
            int count = countMatchingWords(dictionary, review);
            hotelMap.put(id, hotelMap.getOrDefault(id, 0) + count);
        }

        hotelList = new ArrayList<>(hotelMap.entrySet());
        hotelList.sort((o1, o2) -> {
            if (o2.getValue().intValue() == o1.getValue().intValue()) {
                return o1.getKey() - o2.getKey();
            }
            return o2.getValue() - o1.getValue();
        });
        return hotelList.stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }

    private int countMatchingWords(Set<String> dictionary, String review) {
        int count = 0;
        String[] words = review.split("[ ,.]");
        for (String word : words) {
            if (dictionary.contains(word)) {
                count++;
            }
        }
        return count;
    }
}
