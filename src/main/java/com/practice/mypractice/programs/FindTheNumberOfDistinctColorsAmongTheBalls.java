package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

public class FindTheNumberOfDistinctColorsAmongTheBalls {

    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        Map<Integer, Integer> numColour = new HashMap<>();
        Map<Integer, Integer> colourCountMap = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int newColour = q[1];
            int num = q[0];
            int oldColour = numColour.getOrDefault(num, 0);
            if (oldColour != 0) {
                decrementColourCount(colourCountMap, oldColour);
            }
            colourCountMap.put(newColour, colourCountMap.getOrDefault(newColour, 0) + 1);
            numColour.put(num, newColour);
            result[i] = colourCountMap.size();
        }

        return result;
    }

    private static void decrementColourCount(Map<Integer, Integer> colourCountMap, int oldColour) {
        colourCountMap.put(oldColour, colourCountMap.get(oldColour) - 1);
        if (colourCountMap.get(oldColour) == 0) {
            colourCountMap.remove(oldColour);
        }
    }

    public static void main(String[] args) {

    }
}
