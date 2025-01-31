package com.practice.mypractice.programs.dream11_leetcode;


/*
Train Arrival and Departure:
Calculate the min number of platforms required at a railway station,
given the arrival and departure times of trains.
*/

import java.util.Arrays;

public class TrainPlatformCalculation {

    public static int findMinimumPlatforms(int[][] trains) {
        int n = trains.length, max = 0;
        int[] arrivals = new int[n];
        int[] departures = new int[n];

        // Extract arrival and departure times
        for (int i = 0; i < n; i++) {
            arrivals[i] = trains[i][0];
            departures[i] = trains[i][1];
        }

        // Sort arrival and departure arrays
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int i = 0, j = 0, platforms = 0;
        while (i < n && j < n) {
            if (arrivals[i] <= departures[j]) {
                i++;
                platforms++;
                max = Math.max(max, platforms);
            } else {
                j++;
                platforms--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] trains = {
                {900, 910}, {940, 1200}, {950, 1120},
                {1100, 1130}, {1500, 1900}, {1800, 2000}
        };
        int result = findMinimumPlatforms(trains);
        System.out.println("Minimum number of platforms required: " + result);
    }
}
