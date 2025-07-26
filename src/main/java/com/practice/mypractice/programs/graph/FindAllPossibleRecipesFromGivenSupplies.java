package com.practice.mypractice.programs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindAllPossibleRecipesFromGivenSupplies {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();

        Set<String> supplySet = new HashSet<>(List.of(supplies));
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, List<String>> adjList = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            indegree.put(recipe, 0);
            adjList.putIfAbsent(recipe, new ArrayList<>());
            for (String ingredient : ingredients.get(i)) {
                if (!supplySet.contains(ingredient)) {
                    adjList.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
                    indegree.put(recipe, indegree.get(recipe) + 1);
                }
            }
            if (indegree.get(recipe) == 0) {
                q.offer(recipe);
            }
        }

        while (!q.isEmpty()) {
            String recipe = q.poll();
            ans.add(recipe);
            for (String neighbour : adjList.get(recipe)) {
                indegree.put(neighbour, indegree.get(neighbour) - 1);
                if (indegree.get(neighbour) == 0) {
                    q.offer(neighbour);
                }
            }
        }

        return ans;
    }


}
