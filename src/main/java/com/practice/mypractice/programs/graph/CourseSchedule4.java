package com.practice.mypractice.programs.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule4 {

    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];
        for (int[] pre : prerequisites) {
            adjList.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
            isPrerequisite[pre[1]][pre[0]] = true;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbour : adjList.get(node)) {
                isPrerequisite[neighbour][node] = true;
                for (int i = 0; i < numCourses; i++) {
                    if (isPrerequisite[node][i]) {
                        isPrerequisite[neighbour][i] = true;
                    }
                }
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPrerequisite[query[1]][query[0]]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(checkIfPrerequisite(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}},
                new int[][]{{0, 4}, {4, 0}, {1, 3}, {3, 0}}));
        System.out.println(checkIfPrerequisite(3, new int[][]{{1, 2}, {1, 0}, {2, 0}},
                new int[][]{{1, 0}, {1, 2}}));
    }
}
