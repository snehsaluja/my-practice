package com.practice.mypractice.programs.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ValidArrangementOfPairs {

    public int[][] validArrangement(int[][] pairs) {

        Map<Integer, LinkedList<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> inOutDegreeMap = new HashMap<>();
        for (int[] pair : pairs) {
            int u = pair[0], v = pair[1];
            adjList.computeIfAbsent(u, k -> new LinkedList<>()).add(v);
            inOutDegreeMap.put(u, inOutDegreeMap.getOrDefault(u, 0) + 1); // Out Degree
            inOutDegreeMap.put(v, inOutDegreeMap.getOrDefault(v, 0) - 1); // In Degree
        }
        int start = pairs[0][0];
        for (Map.Entry<Integer, Integer> entry : inOutDegreeMap.entrySet()) {
            if (entry.getValue() == 1) {
                start = entry.getKey();
                break;
            }
        }

        LinkedList<int[]> result = new LinkedList<>();

        dfs(start, adjList, result);

        int[][] output = new int[result.size()][2];
        int index = 0;
        for (int[] r : result) {
            output[index++] = r;
        }
        return output;
    }

    private void dfs(int start, Map<Integer, LinkedList<Integer>> adjList, LinkedList<int[]> result) {
        LinkedList<Integer> neighbours = adjList.getOrDefault(start, new LinkedList<>());
        while (!neighbours.isEmpty()) {
            int nextNeighbour = neighbours.poll();
            dfs(nextNeighbour, adjList, result);
            result.addFirst(new int[]{start, nextNeighbour});
        }
    }

    public static void main(String[] args) {

    }
}
