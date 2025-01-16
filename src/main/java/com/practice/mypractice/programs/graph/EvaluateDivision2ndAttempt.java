package com.practice.mypractice.programs.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision2ndAttempt {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] answer = new double[queries.size()];

        int n = equations.size();
        Map<String, Map<String, Double>> adjList = getAdjList(equations, values, n);

        for (int i = 0; i < queries.size(); i++) {
            String source = queries.get(i).get(0);
            String destination = queries.get(i).get(1);
            if (!adjList.containsKey(source) || !adjList.containsKey(destination)) {
                answer[i] = -1.0;
                continue;
            }
            double[] ans = {-1.0};
            double temp = 1;
            Set<String> visited = new HashSet<>();
            dfs(source, destination, adjList, visited, ans, temp);
            answer[i] = ans[0];
        }
        return answer;
    }

    private void dfs(String source, String destination, Map<String, Map<String, Double>> adjList, Set<String> visited, double[] ans, double temp) {
        if (visited.contains(source)) {
            return;
        }
        visited.add(source);
        if (source.equals(destination)) {
            ans[0] = temp;
            return;
        }
        for (Map.Entry<String, Double> entry : adjList.get(source).entrySet()) {
            String child = entry.getKey();
            double val = entry.getValue();
            dfs(child, destination, adjList, visited, ans, temp * val);
        }
    }

    private static Map<String, Map<String, Double>> getAdjList(List<List<String>> equations, double[] values, int n) {
        Map<String, Map<String, Double>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            double val = values[i];
            adjList.computeIfAbsent(numerator, k -> new HashMap<>()).put(denominator, val);
            adjList.computeIfAbsent(denominator, k -> new HashMap<>()).put(numerator, 1 / val);
        }
        return adjList;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(calcEquation(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")), new double[]{2.0, 3.0},
                Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x")))));
    }
}
