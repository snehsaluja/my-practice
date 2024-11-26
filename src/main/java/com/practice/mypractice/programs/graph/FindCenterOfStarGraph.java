package com.practice.mypractice.programs.graph;

public class FindCenterOfStarGraph {

    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] inDegree = new int[n + 1];

        for (int[] edge : edges) {
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1)
                return i;
        }

        return -1;
    }

}
