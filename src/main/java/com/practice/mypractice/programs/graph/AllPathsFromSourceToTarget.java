package com.practice.mypractice.programs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsFromSourceToTarget {

    // Simplified:

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        int n = graph.length;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        getAllPathsRec(0, graph, result, list, n - 1);
        return result;
    }

    private void getAllPathsRec(int currNode, int[][] graph, List<List<Integer>> result, List<Integer> currList, int destination) {
        if (currNode == destination) {
            result.add(List.copyOf(currList));
            return;
        }
        for (int neighbour : graph[currNode]) {
            currList.add(neighbour);
            getAllPathsRec(neighbour, graph, result, currList, destination);
            currList.remove(currList.size() - 1);
        }
    }

    // A little overengineered:

    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        int n = graph.length;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] neighbours = graph[i];
            adjList.put(i, new ArrayList<>());
            for (int v : neighbours) {
                adjList.get(i).add(v);
            }
        }
        boolean[] visited = new boolean[n];
        getAllPathsRec2(0, adjList, result, new ArrayList<>(), n, visited);
        return result;
    }

    private void getAllPathsRec2(int currNode, Map<Integer, List<Integer>> adjList, List<List<Integer>> result, List<Integer> currList, int n, boolean[] visited) {
        visited[currNode] = true;
        currList.add(currNode);
        if (currNode == n - 1) {
            result.add(List.copyOf(currList));
        } else {
            for (int neighbour : adjList.get(currNode)) {
                if (!visited[neighbour])
                    getAllPathsRec2(neighbour, adjList, result, currList, n, visited);
            }
        }
        currList.remove(currList.size() - 1);
        visited[currNode] = false;
    }


    public static void main(String[] args) {

    }
}
