package com.practice.mypractice.programs.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindMinimumDiameterAfterMergingTwoTrees {

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int d1 = calcDiameter(edges1);
        int d2 = calcDiameter(edges2);
        return Math.max(Math.max(d1, d2), (d1 + 1) / 2 + (d2 + 1) / 2 + 1);
    }

    private int calcDiameter(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = edges.length + 1;
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }
        int level = 0, remainingNodes = n;
        while (remainingNodes > 2) {
            int size = q.size();
            remainingNodes -= size;
            level++;
            for (int i = 0; i < size; i++) {
                int currNode = q.poll();
                for (int neighbour : adjList.get(currNode)) {
                    degree[neighbour]--;
                    if (degree[neighbour] == 1) {
                        q.offer(neighbour);
                    }
                }
            }
        }
        return (remainingNodes == 2) ? 2 * level + 1 : 2 * level;
    }

    public static void main(String[] args) {

    }
}
