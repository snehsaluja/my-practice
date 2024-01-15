package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPlayersWithZeroOrOneLosses_2225 {

    public List<List<Integer>> findWinners(int[][] matches) {

        Map<Integer, Integer> loosingFreqMap = new HashMap<>();

        for (int[] arr : matches) {
            int winner = arr[0], looser = arr[1];
            loosingFreqMap.put(winner, loosingFreqMap.getOrDefault(winner, 0));
            loosingFreqMap.put(looser, loosingFreqMap.getOrDefault(looser, 0) + 1);
        }

        List<Integer> perfectWinningList = new ArrayList<>();
        List<Integer> lostOneMatch = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : loosingFreqMap.entrySet()) {
            int player = entry.getKey();
            int loosingFreq = entry.getValue();
            if (loosingFreq == 0) {
                perfectWinningList.add(player);
            } else if (loosingFreq == 1) {
                lostOneMatch.add(player);
            }
        }
        Collections.sort(perfectWinningList);
        Collections.sort(lostOneMatch);
        List<List<Integer>> result = new ArrayList<>();
        result.add(perfectWinningList);
        result.add(lostOneMatch);
        return result;
    }

    // Playing with Constraint : [ 1 <= winneri, loseri <= 105 ]
    public static List<List<Integer>> findWinnersOptimized(int[][] matches) {

        int[] losses = new int[100001];
        for (int i = 0; i < matches.length; i++) {
            int win = matches[i][0], loss = matches[i][1];
            if (losses[win] == 0) {
                losses[win] = -1;
            }
            if (losses[loss] == -1) {
                losses[loss] = 1;
            } else {
                losses[loss]++;
            }
        }
        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < losses.length; i++) {
            if (losses[i] == -1) {
                zeroLoss.add(i);
            } else if (losses[i] == 1) {
                oneLoss.add(i);
            }
        }
        result.add(zeroLoss);
        result.add(oneLoss);
        return result;
    }

    public static void main(String[] args) {
        int matches[][] = new int[][]{{2, 3}, {1, 3}, {5, 4}, {6, 4}};
        System.out.println(findWinnersOptimized(matches));
    }
}
