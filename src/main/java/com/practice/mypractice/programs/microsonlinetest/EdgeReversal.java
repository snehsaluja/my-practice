package com.practice.mypractice.programs.microsonlinetest;

import java.util.*;

public class EdgeReversal {

    static class Edge {
        int to;
        int reverseCost;

        Edge(int to, int reverseCost) {
            this.to = to;
            this.reverseCost = reverseCost;
        }
    }

    public static int[] countReverseEdges(int g_nodes, int[] g_from, int[] g_to) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= g_nodes; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph with direction information
        for (int i = 0; i < g_from.length; i++) {
            int u = g_from[i];
            int v = g_to[i];
            graph.get(u).add(new Edge(v, 0)); // original direction
            graph.get(v).add(new Edge(u, 1)); // reverse direction
        }

        int[] res = new int[g_nodes + 1];
        boolean[] visited = new boolean[g_nodes + 1];

        // Step 1: DFS to calculate reversals from node 1
        res[1] = dfsCount(graph, 1, visited);

        // Step 2: DFS to calculate for all other nodes
        Arrays.fill(visited, false);
        dfsAll(graph, 1, res, visited);

        // Remove 0-th index as nodes are 1-indexed
        return Arrays.copyOfRange(res, 1, g_nodes + 1);
    }

    // Count reverse edges needed from root
    private static int dfsCount(List<List<Edge>> graph, int node, boolean[] visited) {
        visited[node] = true;
        int count = 0;

        for (Edge edge : graph.get(node)) {
            if (!visited[edge.to]) {
                count += edge.reverseCost + dfsCount(graph, edge.to, visited);
            }
        }

        return count;
    }

    // Calculate reversals needed for each node
    private static void dfsAll(List<List<Edge>> graph, int node, int[] res, boolean[] visited) {
        visited[node] = true;

        for (Edge edge : graph.get(node)) {
            int neighbor = edge.to;
            if (!visited[neighbor]) {
                res[neighbor] = res[node] + (edge.reverseCost == 1 ? -1 : 1);
                dfsAll(graph, neighbor, res, visited);
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        int g_nodes = 4;
        int[] g_from = {1, 2, 3};
        int[] g_to = {4, 4, 4};

        int[] result = countReverseEdges(g_nodes, g_from, g_to);
        System.out.println(Arrays.toString(result)); // Output: [2, 2, 2, 3]


        System.out.println(Arrays.toString(countReverseEdges(4, new int[]{1,2,3}, new int[]{2,3,4})));
        System.out.println(Arrays.toString(countReverseEdges(3, new int[]{2,2}, new int[]{1,3})));
    }
}