package com.practice.mypractice.programs.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int[] edge : edges) {
            adjMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjMap.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) {
                q.offer(i);
            }
        }

        while (n > 2) {
            int size = q.size();
            n -= size;
            while (size > 0) {
                int v = q.poll();
                inDegree[v]--;
                List<Integer> neighbors = adjMap.get(v);
                for (int u : neighbors) {
                    inDegree[u]--;
                    if (inDegree[u] == 1) {
                        q.offer(u);
                    }
                }
                size--;
            }
        }
        /*List<Integer> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i]>0){

            }
        }*/
        return new ArrayList<>(q);
    }

    public static void main(String[] args) {

    }
}
