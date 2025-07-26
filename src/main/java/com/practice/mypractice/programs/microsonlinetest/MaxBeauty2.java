package com.practice.mypractice.programs.microsonlinetest;

import java.util.*;

public class MaxBeauty2 {

    public static long maxBeauty(int treeNodes, List<Integer> treeFrom, List<Integer> treeTo, List<Integer> a) {
        // 1. Build adjacency list
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

        int[] subtreeSize = new int[treeNodes + 1];
        long[] subtreeSum = new long[treeNodes + 1];

        boolean[] visited = new boolean[treeNodes + 1];

        // 2. Compute subtreeSum & initial root beauty using BFS
        int root = 1;
        long[] dist = new long[treeNodes + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = true;

        long rootBeauty = 0;
        long totalValueSum = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            //totalValueSum += a.get(node - 1);
            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    dist[nei] = dist[node] + 1;
                    visited[nei] = true;
                    queue.offer(nei);
                }
            }
        }

        for (int i = 1; i <= treeNodes; i++) {
            rootBeauty += dist[i] * a.get(i - 1);
        }

        // 3. Get subtree sums and sizes using DFS
        Arrays.fill(visited, false);
        dfs(root, -1, graph, a, subtreeSum, subtreeSize, visited);

        // 4. Propagate beauty using DFS
        long[] beauty = new long[treeNodes + 1];
        beauty[root] = rootBeauty;

        Arrays.fill(visited, false);
        visited[root] = true;

        long[] result = new long[1];
        result[0] = rootBeauty;

        dfsBeauty(root, graph, a, subtreeSum, beauty, visited, result);

        return result[0];
    }

    private static void dfs(int node, int parent, List<List<Integer>> graph, List<Integer> a,
                            long[] subtreeSum, int[] subtreeSize, boolean[] visited) {
        visited[node] = true;
        subtreeSum[node] = a.get(node - 1);
        subtreeSize[node] = 1;

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                dfs(nei, node, graph, a, subtreeSum, subtreeSize, visited);
                subtreeSum[node] += subtreeSum[nei];
                subtreeSize[node] += subtreeSize[nei];
            }
        }
    }

    private static void dfsBeauty(int node, List<List<Integer>> graph, List<Integer> a,
                                  long[] subtreeSum, long[] beauty, boolean[] visited, long[] result) {
        visited[node] = true;

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                // move root from node to nei
                beauty[nei] = beauty[node] + (subtreeSum[1] - 2 * subtreeSum[nei]);
                result[0] = Math.max(result[0], beauty[nei]);
                dfsBeauty(nei, graph, a, subtreeSum, beauty, visited, result);
            }
        }
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
