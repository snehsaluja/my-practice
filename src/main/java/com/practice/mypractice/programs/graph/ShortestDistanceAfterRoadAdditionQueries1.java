package com.practice.mypractice.programs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestDistanceAfterRoadAdditionQueries1 {

    public static void main(String[] args) {

    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
            if (i != n - 1) {
                adjList.get(i).add(i + 1);
            }
        }

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = i;
        }
        int[] ans = new int[queries.length];
        int index = 0;
        for (int[] q : queries) {
            int u = q[0], v = q[1];
            adjList.get(u).add(v);

            for (int i = 0; i < n; i++) {
                for (int neighbor : adjList.get(i)) {
                    if (dist[neighbor] > dist[i] + 1)
                        dist[neighbor] = dist[i] + 1;
                }
            }
            ans[index++] = dist[n - 1];
        }

        return ans;
    }


}
