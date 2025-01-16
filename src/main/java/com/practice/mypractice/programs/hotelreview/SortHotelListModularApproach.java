package com.practice.mypractice.programs.hotelreview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SortHotelListModularApproach {

    public List<Integer> sortHotels(String words, String[][] hotelReviews) {
        Set<String> dictionary = new HashSet<>(Arrays.asList(words.split(" ")));
        Map<Integer, Hotel> hotelMap = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<Hotel> hotelList;

        for (int i = 0; i < hotelReviews.length; i++) {
            int id = Integer.parseInt(hotelReviews[i][0]);
            String review = hotelReviews[i][1];
            Hotel hotel = hotelMap.computeIfAbsent(id, k -> new Hotel(id));
            hotel.reviews.add(review);
            int count = countMatchingWords(dictionary, review);
            hotel.count += count;
            //map.put(id, map.getOrDefault(id, 0) + count);
        }
        hotelList = new ArrayList<>(hotelMap.values());
        hotelList.sort((o1, o2) -> {
            if (o2.count == o1.count) {
                return o1.id - o2.id;
            }
            return o2.count - o1.count;
        });
        return hotelList.stream().map(hotel -> hotel.id).collect(Collectors.toList());
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

    class Hotel {
        int id;
        List<String> reviews;
        int count;

        public Hotel(int id) {
            this.id = id;
            reviews = new ArrayList<>();
        }
    }
}
