package com.practice.mypractice.programs.graph;

public class FindChampion2 {

    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int v = edge[1];
            indegree[v]++;
        }
        int champ = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0 && champ == -1) {
                champ = i;
            } else if (indegree[i] == 0 && champ != -1) {
                champ = -1;
                break;
            }
        }
        return champ;
    }

}
