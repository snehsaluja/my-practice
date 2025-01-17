package com.practice.mypractice.programs.hotelreviewsentimentanalysis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortHotelListBySentimentAnalysisTest {

    SortHotelListBySentimentAnalysis service = new SortHotelListBySentimentAnalysis();

    @Test
    public void testHotels_A() {
        String positiveWords = "excellent wonderful amazing fantastic outstanding perfect beautiful great friendly comfortable nice good";
        String negativeWords = "terrible horrible awful disgusting dirty unfriendly noisy uncomfortable rude poor";
        String[][] reviews = {
                {"1", "This hotel has a nice view of the citycenter. The location is perfect. wonderful pool. comfortable bed"},
                {"2", "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth."},
                {"1", "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel."},
                {"1", "They said I couldn't take my dog and there were other guests with dogs! That is not fair. awful experience"},
                {"2", "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter."}};
        Assertions.assertEquals(Arrays.asList(1, 2), service.sortHotels(positiveWords, negativeWords, reviews));
    }

    @Test
    public void testHotels_B() {
        String positiveWords = "excellent wonderful amazing fantastic outstanding perfect beautiful great friendly comfortable nice good";
        String negativeWords = "terrible horrible awful disgusting dirty unfriendly noisy uncomfortable rude poor";
        String[][] reviews = {
                {"1", "This hotel has a nice view of the citycenter. The location is perfect. wonderful pool. comfortable bed"},
                {"2", "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth."},
                {"1", "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel."},
                {"1", "They said I couldn't take my dog and there were other guests with dogs! That is not fair. awful experience"},
                {"2", "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter."},
                {"0", "They breakfast I couldn't take breakfast dog location citycenter were citycenter location with dogs! That is not fair."},};
        Assertions.assertEquals(Arrays.asList(1, 2, 0), service.sortHotels(positiveWords, negativeWords, reviews));
    }
}
