package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class MostProfitAssigningWork {
    public static void main(String[] args) {
        /*int[] difficulty = {68, 35, 52, 47, 86};
        int[] profit = {67, 17, 1, 81, 3};
        int[] worker = {92, 10, 85, 84, 82};*/
        int[] difficulty = {66, 1, 28, 73, 53, 35, 45, 60, 100, 44, 59, 94, 27, 88, 7, 18, 83, 18, 72, 63};
        int[] profit = {66, 20, 84, 81, 56, 40, 37, 82, 53, 45, 43, 96, 67, 27, 12, 54, 98, 19, 47, 77};
        int[] worker = {61, 33, 68, 38, 63, 45, 1, 10, 53, 23, 66, 70, 14, 51, 94, 18, 28, 78, 100, 16};

        System.out.println(maxProfitAssignment_0(difficulty, profit, worker));
        System.out.println("===============================");
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }

    public static int maxProfitAssignment_0(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int sum = 0;
        for (int i = 0; i < difficulty.length; i++) {
            map.put(difficulty[i], profit[i]);
        }
        for (int i = 0; i < worker.length; i++) {
            Optional<Map.Entry<Integer, Integer>> max = map.headMap(worker[i], true).entrySet().stream()
                    .max(Comparator.comparingInt(Map.Entry::getValue));
            int maxPro = max.isPresent() ? max.get().getValue() : 0;
            System.out.println("worker : " + worker[i] + " ; maxPro: " + maxPro + " max.diff KEY : " + (max.map(Map.Entry::getKey).orElse(null)));
            sum += maxPro;
        }
        return sum;
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int sum = 0;
        int maxDiff = Arrays.stream(difficulty).max().orElse(0);
        int[] maxProfitTillDifficulty = new int[maxDiff + 1];
        for (int i = 0; i < difficulty.length; i++) {
            maxProfitTillDifficulty[difficulty[i]] = Math.max(profit[i], maxProfitTillDifficulty[difficulty[i]]);
        }
        for (int i = 1; i <= maxDiff; i++) {
            maxProfitTillDifficulty[i] = Math.max(maxProfitTillDifficulty[i], maxProfitTillDifficulty[i - 1]);
        }

        for (int i = 0; i < worker.length; i++) {
            if (worker[i] > maxDiff) {
                sum += maxProfitTillDifficulty[maxDiff];
                System.out.println(worker[i] + " --- " + maxProfitTillDifficulty[maxDiff]);
            } else {
                sum += maxProfitTillDifficulty[worker[i]];
                System.out.println(worker[i] + " --- " + maxProfitTillDifficulty[worker[i]]);
            }
        }
        return sum;
    }
}
