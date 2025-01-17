package com.practice.mypractice.programs.hotelreviewsentimentanalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SortHotelListBySentimentAnalysis {

    // Positive words weight = 3 points
    // Negative words weight = -1 points

    private static final int POSITIVE_SCORE = 3;
    private static final int NEGATIVE_SCORE = -1;

    public List<Integer> sortHotels(String positiveWords, String negativeWords, String[][] hotelReviews) {
        Set<String> positiveDict = new HashSet<>(Arrays.asList(positiveWords.split(" ")));
        Set<String> negativeDict = new HashSet<>(Arrays.asList(negativeWords.split(" ")));
        Map<Integer, Integer> hotelMap = new HashMap<>();
        List<Map.Entry<Integer, Integer>> hotelList;

        for (int i = 0; i < hotelReviews.length; i++) {
            int id = Integer.parseInt(hotelReviews[i][0]);
            String review = hotelReviews[i][1];
            int score = fetchScore(positiveDict, negativeDict, review);
            hotelMap.put(id, hotelMap.getOrDefault(id, 0) + score);
        }

        hotelList = new ArrayList<>(hotelMap.entrySet());
        hotelList.sort((o1, o2) -> {
            if (o2.getValue().intValue() == o1.getValue().intValue()) {
                return o1.getKey() - o2.getKey();
            }
            return o2.getValue() - o1.getValue();
        });
        //System.out.println(hotelList);
        return hotelList.stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }

    private int fetchScore(Set<String> positiveDict, Set<String> negativeDict, String review) {
        int score = 0;
        String[] words = review.split("[ ,.]");
        for (String word : words) {
            if (positiveDict.contains(word)) {
                score += POSITIVE_SCORE;
            } else if (negativeDict.contains(word)) {
                score += NEGATIVE_SCORE;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        SortHotelListBySentimentAnalysis ob = new SortHotelListBySentimentAnalysis();
        String positiveWords = "excellent wonderful amazing fantastic outstanding perfect beautiful great friendly comfortable nice good";
        String negativeWords = "terrible horrible awful disgusting dirty unfriendly noisy uncomfortable rude poor";
        String[][] reviews = {
                {"1", "This hotel has a nice view of the citycenter. The location is perfect. wonderful pool. comfortable bed"},
                {"2", "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth."},
                {"1", "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel."},
                {"1", "They said I couldn't take my dog and there were other guests with dogs! That is not fair. awful experience"},
                {"2", "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter."}};
        System.out.println(ob.sortHotels(positiveWords, negativeWords, reviews));

        String[][] reviews2 = {
                {"1", "This hotel has a nice view of the citycenter. The location is perfect. wonderful pool. comfortable bed"},
                {"2", "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth."},
                {"1", "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel."},
                {"1", "They said I couldn't take my dog and there were other guests with dogs! That is not fair. awful experience"},
                {"2", "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter."},
                {"0", "They breakfast I couldn't take breakfast dog location citycenter were citycenter location with dogs! That is not fair."},};
        System.out.println(ob.sortHotels(positiveWords, negativeWords, reviews2));
    }
}
