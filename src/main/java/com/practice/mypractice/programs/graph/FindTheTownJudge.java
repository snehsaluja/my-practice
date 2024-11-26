package com.practice.mypractice.programs.graph;

public class FindTheTownJudge {

    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0)
            return n == 1 ? 1 : -1;
        int res = -1;
        int[] indegree = new int[n];
        int[] outdegree = new int[n];

        for (int[] t : trust) {
            int v = t[0];
            int u = t[1];
            outdegree[v - 1]++;
            indegree[u - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i + 1;
            }
        }
        return res;
    }

    public int findJudgeOptimized(int n, int[][] trust) {

        int[] degree = new int[n + 1];
        for (int[] t : trust) {
            degree[t[1]]++;
            degree[t[0]]--;
        }
        for (int i = 1; i <= n; i++) {
            if (degree[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }


}
