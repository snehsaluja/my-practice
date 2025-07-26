package com.practice.mypractice.programs;

import java.util.Arrays;

public class MaximumMatchingOfPlayersWithTrainers {

    public static void main(String[] args) {

    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int i = 0, j = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
