package com.practice.mypractice.programs.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public static int findCircleNum_BFS(int[][] isConnected) {
        Queue<Integer> q = new LinkedList<>();
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0, index = 1, visitedCount = 0;
        q.offer(0);
        while (visitedCount != n) {
            while (!q.isEmpty()) {
                int u = q.poll();
                if (!visited[u]) {
                    count++;
                    visited[u] = true;
                    visitedCount++;
                }
                for (int i = 0; i < n; i++) {
                    if (u != i && isConnected[u][i] == 1 && !visited[i]) {
                        visited[i] = true;
                        visitedCount++;
                        q.offer(i);
                    }
                }
            }
            while (index < n && visited[index]) {
                index++;
            }
            q.offer(index);
        }
        return count;
    }


    // DFS approach is faster in leetcode , reason - less number of if-else checks are required.
    public static int findCircleNum_DFS(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0, index = 1, visitedCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                visited[i] = true;
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }

    private static void dfs(int[][] isConnected, int curr, boolean[] visited) {
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[curr][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(isConnected, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum_BFS(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));
        int[][] arr = {{1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1}};

        System.out.println(findCircleNum_BFS(arr));
    }

}
