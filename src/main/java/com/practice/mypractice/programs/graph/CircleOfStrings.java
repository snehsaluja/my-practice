package com.practice.mypractice.programs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CircleOfStrings {

    public static boolean isCircle(String[] strings) {

        int[] indegree = new int[26];
        int[] outdegree = new int[26];
        boolean[] visited = new boolean[strings.length];
        Queue<Integer> q = new LinkedList<>();
        Map<Character, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            char in = str.charAt(0);
            char out = str.charAt(str.length() - 1);
            indegree[in - 'a']++;
            outdegree[out - 'a']++;
            adjList.computeIfAbsent(in, k -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < 26; i++) {
            if (indegree[i] != outdegree[i]) {
                return false;
            }
        }

        q.offer(0);
        visited[0] = true;
        int cycleCount = 1;
        while (!q.isEmpty()) {
            int currIndex = q.poll();
            String current = strings[currIndex];
            List<Integer> nextList = adjList.get(current.charAt(current.length() - 1));
            for (int next : nextList) {
                if (!visited[next]) {
                    cycleCount++;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        return cycleCount == strings.length;
    }

    public static void main(String[] args) {
        System.out.println(isCircle(new String[]{"abc","cde","efg","gha"}));
        System.out.println(isCircle(new String[]{"abc","cde","efg","ghi"}));
        System.out.println(isCircle(new String[]{"abc","gde","efa","chi","ig"}));
        System.out.println(isCircle(new String[]{"aa","aa","aa","aa"}));
    }

}
