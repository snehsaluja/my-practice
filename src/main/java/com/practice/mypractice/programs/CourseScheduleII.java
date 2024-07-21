package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public static void main(String[] args) {

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // BFS Approach:

        int[] sortedOrder = new int[numCourses];
        int[] inDegree = new int[numCourses];               // HasMap can also be considered
        List<List<Integer>> adjList = new ArrayList<>();    // HasMap can also be considered

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int parent = p[1], child = p[0];
            inDegree[child]++;
            adjList.get(parent).add(child);
        }

        Queue<Integer> sources = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                sources.add(i);
            }
        }

        int index = 0;
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedOrder[index++] = vertex;
            List<Integer> children = adjList.get(vertex);
            for (int child : children) {
                inDegree[child]--;
                if (inDegree[child]==0){
                    sources.add(child);
                }
            }
        }

        if (index != numCourses){
            return new int[0];
        }

        return sortedOrder;
    }
}
