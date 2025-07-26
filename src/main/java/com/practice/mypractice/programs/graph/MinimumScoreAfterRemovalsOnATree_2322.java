package com.practice.mypractice.programs.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumScoreAfterRemovalsOnATree_2322 {

    public int minimumScore(int[] nums, int[][] edges) {
        int minScore = Integer.MAX_VALUE;
        int n = nums.length;

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        int[] parents = new int[nums.length];
        int[] xor = new int[nums.length];
        Arrays.fill(parents, -1);

        int totalXor = dfsCalculateXor(0, -1, adjList, parents, xor, nums);

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = xor[i];
                int b = xor[j];
                int c;

                if (isAncestor(i, j, parents)) {
                    c = totalXor ^ a;
                    a = a ^ b;
                } else if (isAncestor(j, i, parents)) {
                    c = totalXor ^ b;
                    b = b ^ a;
                } else {
                    //disjoint
                    c = totalXor ^ a ^ b;
                }
                int minXor = Math.min(a, Math.min(b, c));
                int maxXor = Math.max(a, Math.max(b, c));
                minScore = Math.min(minScore, maxXor - minXor);
            }
        }
        return minScore;
    }

    private boolean isAncestor(int parentNode, int currNode, int[] parents) {
        while (currNode != -1) {
            if (parentNode == currNode) {
                return true;
            }
            currNode = parents[currNode];
        }
        return false;
    }

    private int dfsCalculateXor(int current, int parentNode, Map<Integer, List<Integer>> adjList, int[] parents, int[] xor, int[] nums) {
        parents[current] = parentNode;
        xor[current] = nums[current];

        for (int neighbour : adjList.get(current)) {
            if (neighbour != parentNode) {
                xor[current] ^= dfsCalculateXor(neighbour, current, adjList, parents, xor, nums);
            }
        }
        return xor[current];
    }

    public static void main(String[] args) {

    }
}
