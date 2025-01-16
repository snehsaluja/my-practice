package com.practice.mypractice.programs.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

    static class EqNode {
        String str;
        double weight;

        public EqNode(String str, double weight) {
            this.str = str;
            this.weight = weight;
        }
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] answer = new double[queries.size()];
        Map<String, List<EqNode>> adjList = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String numerator = eq.get(0);
            String denominator = eq.get(1);
            double val = values[i];
            adjList.computeIfAbsent(numerator, k -> new ArrayList<>()).add(new EqNode(denominator, val));
            adjList.computeIfAbsent(denominator, k -> new ArrayList<>()).add(new EqNode(numerator, (1 / val)));
        }

        for (int i = 0; i < queries.size(); i++) {

            List<String> q = queries.get(i);
            String src = q.get(0);
            String dest = q.get(1);
            if (!adjList.containsKey(src) || !adjList.containsKey(dest)) {
                answer[i] = -1.0;
                continue;
            }

            Set<String> visited = new HashSet<>();
            double tempVal = 1.0;
            double[] ans = {-1.0};
            dfs(src, dest, adjList, visited, ans, tempVal);
            answer[i] = ans[0];
        }

        return answer;
    }

    private static void dfs(String src, String dest, Map<String, List<EqNode>> adjList, Set<String> visited, double[] ans, double tempVal) {
        if (visited.contains(src)) {
            return;
        }
        visited.add(src);
        if (src.equals(dest)) {
            ans[0] = tempVal;
            return;
        }

        for (EqNode node : adjList.get(src)) {
            dfs(node.str, dest, adjList, visited, ans, tempVal * node.weight);
        }
    }

    public double[] calcEquation_complexCalculations(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] answer = new double[queries.size()];
        Map<String, List<EqNode>> adjList = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String numerator = eq.get(0);
            String denominator = eq.get(1);
            double val = values[i];
            /*Set<Character> numerSet = new HashSet<>();
            Set<Character> denomSet = new HashSet<>();
            for (char n : numerator.toCharArray()) {
                numerSet.add(n);
            }
            for (char n : denominator.toCharArray()) {
                denomSet.add(n);
            }
            Set<Character> temp = new HashSet<>(numerSet);
            temp.removeAll(denomSet);
            denomSet.removeAll(numerSet);
            StringBuilder src = new StringBuilder();
            for (char ch : numerSet) {
                src.append(ch);
            }
            StringBuilder dest = new StringBuilder();
            for (char ch : denomSet) {
                dest.append(ch);
            }*/
            adjList.computeIfAbsent(numerator, k -> new ArrayList<>()).add(new EqNode(denominator, val));
            adjList.computeIfAbsent(denominator, k -> new ArrayList<>()).add(new EqNode(numerator, (1 / val)));
        }


        return null;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(calcEquation(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")), new double[]{2.0, 3.0},
                Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x")))));
    }
}
