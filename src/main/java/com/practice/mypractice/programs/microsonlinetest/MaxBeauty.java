package com.practice.mypractice.programs.microsonlinetest;

import java.util.*;

public class MaxBeauty {

    public static long maxBeauty(int treeNodes, List<Integer> treeFrom, List<Integer> treeTo, List<Integer> a) {
        // Step 1: Build the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= treeNodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < treeFrom.size(); i++) {
            int u = treeFrom.get(i);
            int v = treeTo.get(i);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        long maxBeauty = 0;

        // Step 2: For each node, do BFS and calculate beauty
        for (int start = 1; start <= treeNodes; start++) {
            long beauty = computeBeauty(start, graph, a, treeNodes);
            maxBeauty = Math.max(maxBeauty, beauty);
        }

        return maxBeauty;
    }

    private static long computeBeauty(int start, List<List<Integer>> graph, List<Integer> a, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>(); // [node, distance]
        queue.add(new int[]{start, 0});
        visited[start] = true;
        long totalBeauty = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int dist = curr[1];

            totalBeauty += (long) dist * a.get(node - 1); // a is 0-indexed

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, dist + 1});
                }
            }
        }

        return totalBeauty;
    }

    public static void main(String[] args) {
        int treeNodes = 2;
        List<Integer> treeFrom = List.of(1);
        List<Integer> treeTo = List.of(2);
        List<Integer> a = List.of(3, 4);

        System.out.println(maxBeauty(treeNodes, treeFrom, treeTo, a));
        System.out.println(maxBeauty(3, List.of(1,2), List.of(2,3), List.of(3,2,1)));
        System.out.println(maxBeauty(4, List.of(1,3,3), List.of(3,4,2), List.of(1,1,4,3)));
    }
}