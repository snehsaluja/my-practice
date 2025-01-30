package com.practice.mypractice.programs.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DivideNodesIntoTheMaximumNumberOfGroups {

    public static int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int[] colour = new int[n + 1];
        Arrays.fill(colour, -1);
        List<List<Integer>> components = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (colour[i] == -1) {
                List<Integer> component = new ArrayList<>();
                if (!isBipartite(i, 0, component, n, adjList, colour))
                    return -1;
                components.add(component);
            }
        }

        int total = 0;
        for (List<Integer> comp : components) {
            total += maxGroupInComponent(comp, n, adjList);
        }

        return total;
    }

    private static int maxGroupInComponent(List<Integer> comp, int n, List<List<Integer>> adjList) {
        int maxDepth = 0;
        for (int start : comp) {
            int[] depth = new int[n + 1];
            Arrays.fill(depth, -1);
            Queue<Integer> q = new LinkedList<>();
            q.offer(start);
            depth[start] = 0;
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int neighbour : adjList.get(node)) {
                    if (depth[neighbour] == -1) {
                        depth[neighbour] = depth[node] + 1;
                        maxDepth = Math.max(maxDepth, depth[neighbour]);
                        q.offer(neighbour);
                    }
                }
            }
        }
        return maxDepth + 1;
    }

    private static boolean isBipartite(int node, int c, List<Integer> component, int n, List<List<Integer>> adjList, int[] colour) {
        colour[node] = c;
        component.add(node);
        for (int neighbour : adjList.get(node)) {
            if (colour[neighbour] == c) return false;
            if (colour[neighbour] == -1 && !isBipartite(neighbour, 1 - c, component, n, adjList, colour))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(magnificentSets(6, new int[][]{{1, 2}, {1, 4}, {1, 5}, {2, 6}, {2, 3}, {4, 6}}));
    }
}
