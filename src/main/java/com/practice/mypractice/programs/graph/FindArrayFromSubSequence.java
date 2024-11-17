package com.practice.mypractice.programs.graph;

import com.practice.mypractice.programs.basics.A;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FindArrayFromSubSequence {

    public static void main(String[] args) {

        int[][] input = {
                {1, 2, 3},
                {1, 2},
                {3, 4},
                {5, 2},
                {0, 5, 4}};
        int n = 6;
        List<Integer> ans = getAnswer(input, n);
        System.out.println(ans);
    }

    private static List<Integer> getAnswer(int[][] input, int n) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        int[] inDegree = new int[n];
/*
        {1, 2, 3},
        {1, 2},
        {3, 4},
        {5, 2},
        {0, 5, 4}} */

        for (int[] sub : input) {
            for (int i = 0; i < sub.length - 1; i++) {
                int v = sub[i], u = sub[i + 1];
                adjList.computeIfAbsent(v, (k) -> new ArrayList<>()).add(u);
                inDegree[u]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int v = q.poll();
            ans.add(v);
            if (adjList.get(v) != null) {
                for (int u : adjList.get(v)) {
                    inDegree[u]--;
                    if (inDegree[u] == 0) {
                        q.offer(u);
                    }
                }
            }
        }
        System.out.println(ans);
        return (ans.size() == n) ? ans : null;
    }


}
