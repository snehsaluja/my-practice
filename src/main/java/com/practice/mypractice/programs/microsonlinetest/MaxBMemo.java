package com.practice.mypractice.programs.microsonlinetest;


import java.util.*;

public class MaxBMemo {
    public static long maxBeauty(int treeNodes, List<Integer> treeFrom, List<Integer> treeTo, List<Integer> a) {
        // Step 1: Build adjacency list
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

        // Memoization
        Map<Integer, int[]> distanceMap = new HashMap<>();
        Map<Integer, Long> beautyMap = new HashMap<>();

        long maxBeauty = 0;

        // Step 2: For each node, compute its beauty using cached distances
        for (int node = 1; node <= treeNodes; node++) {
            int[] dist = getDistancesBFS(node, treeNodes, graph, distanceMap);
            long beauty = 0;
            for (int i = 1; i <= treeNodes; i++) {
                beauty += (long) dist[i] * a.get(i - 1);
            }
            beautyMap.put(node, beauty);
            maxBeauty = Math.max(maxBeauty, beauty);
        }

        return maxBeauty;
    }

    private static int[] getDistancesBFS(int start, int n, List<List<Integer>> graph,
                                         Map<Integer, int[]> distanceMap) {
        if (distanceMap.containsKey(start)) {
            return distanceMap.get(start);
        }

        int[] dist = new int[n + 1]; // index 1-based
        Arrays.fill(dist, -1);
        dist[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int neighbor : graph.get(u)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[u] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        distanceMap.put(start, dist);
        return dist;
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
