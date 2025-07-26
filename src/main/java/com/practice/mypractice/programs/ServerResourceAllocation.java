package com.practice.mypractice.programs;

import java.util.*;

public class ServerResourceAllocation {

    public List<Integer> getResources(int inc, int dec, List<Integer> performance) {
        int n = performance.size();
        List<Integer> allocation = new ArrayList<>(Collections.nCopies(n, 0));

        // Get unique performance values and sort in descending order
        TreeSet<Integer> sortedPerformance = new TreeSet<>(Comparator.reverseOrder());
        sortedPerformance.addAll(performance);

        // Map performance to rank
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int perf : sortedPerformance) {
            rankMap.put(perf, rank);
            rank++;
        }

        // Count occurrences of each performance value
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int p : performance) {
            countMap.put(p, countMap.getOrDefault(p, 0) + 1);
        }

        // Calculate resource allocation
        for (int i = 0; i < n; i++) {
            int serverRank = rankMap.get(performance.get(i));
            int sameRankCount = countMap.get(performance.get(i));
            allocation.set(i, inc * (n + 1 - serverRank) - dec * sameRankCount);
        }

        return allocation;
    }


    // 2nd way :
    public List<Integer> getResources2(int inc, int dec, List<Integer> performance) {
        int n = performance.size();
        List<Integer> allocation = new ArrayList<>(Collections.nCopies(n, 0));

        // Get unique performance values and sort in descending order
        List<Integer> sortedPerformance = new ArrayList<>(new HashSet<>(performance));
        sortedPerformance.sort(Comparator.reverseOrder());

        // Map performance to rank
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int perf : sortedPerformance) {
            rankMap.put(perf, rank);
            rank++;
        }

        // Count occurrences of each performance value
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int p : performance) {
            countMap.put(p, countMap.getOrDefault(p, 0) + 1);
        }

        // Calculate resource allocation
        for (int i = 0; i < n; i++) {
            int serverRank = rankMap.get(performance.get(i));
            int sameRankCount = countMap.get(performance.get(i));
            allocation.set(i, inc * (n + 1 - serverRank) - dec * sameRankCount);
        }

        return allocation;
    }

    public static void main(String[] args) {
        ServerResourceAllocation ob = new ServerResourceAllocation();

        List<Integer> performance = Arrays.asList(3, 2, 4, 3, 5, 5);
        int inc = 500;
        int dec = 100;
        List<Integer> result = ob.getResources(inc, dec, performance);
        System.out.println(result);


        System.out.println(ob.getResources(200, 50, Arrays.asList(2, 1, 3, 3, 1)));
    }
}
