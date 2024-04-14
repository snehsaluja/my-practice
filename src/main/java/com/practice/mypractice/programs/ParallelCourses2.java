package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParallelCourses2 {

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        convertToAdjList(relations, adjList);

        //for ()

        return 0;
    }

    private void convertToAdjList(int[][] relations, Map<Integer, List<Integer>> adjList) {

        for (int i = 0; i < relations.length; i++) {
            int end = relations[i][0];
            int start = relations[i][1];
            adjList.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
        }
    }

    public static void main(String[] args) {

    }
}
