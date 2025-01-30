package com.practice.mypractice.interview25;

import java.util.*;
import java.io.*;

public class GrouponQ1 {

    public static String ArrayChallenge(String[] strArr) {
        String word = strArr[0], dict = strArr[1];

        String[] dictionary = dict.split(",");
        Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        String output = "";

        for (String w : dictionary) {
            if (word.startsWith(w)) {
                String secondWord = word.substring(w.length());
                if (dictionarySet.contains(secondWord)) {
                    output = w + "," + word.substring(w.length());
                    //return output;
                    break;
                }
            }
        }
        if (output.isEmpty())
            output = "not possible";

        String challengeToken = "z24i3a59";
        StringBuilder transformedOutput = new StringBuilder(output);
        transformedOutput.append(challengeToken);
        for (int i = 3; i < transformedOutput.length(); i += 4) {
            transformedOutput.setCharAt(i, '_');
        }
        return transformedOutput.toString();
    }



    public static String ArrayChallenge2(String[] strArr) {
        // code goes here

        Map<Integer, Integer> parentMap = new HashMap<>();
        Map<Integer, List<Integer>> childMap = new HashMap<>(); // this is the adjacency list of the Tree
        Set<Integer> allNodes = new HashSet<>();

        for (String pair : strArr) {
            String[] p = pair.replaceAll("[()]","").split(",");
            int child = Integer.parseInt(p[0]);
            int parent = Integer.parseInt(p[1]);

            if (parentMap.containsKey(child)) {
                return "false"; // this means a child already has a parent
            }
            parentMap.put(child, parent);

            childMap.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
            if (childMap.get(parent).size() > 2){
                return "false";
            }
            allNodes.add(parent);
            allNodes.add(child);
        }
        // Finding the root
        Set<Integer> children = parentMap.keySet();
        Integer root = null;

        for (int currentNode : allNodes) {
            if (!children.contains(currentNode)) {
                if (root == null) {
                    root = currentNode;
                } else {  // Multiple root nodes found
                    return "false";
                }
            }
        }

        if(root == null) {  // If no root is found
            return "false";
        }

        // Checking for Cycle
        if(hasCycle(root, childMap, new HashSet<>())){
            return "false";
        }
        return "true";
    }

    // DFS Traversal to check if cycle exists or not:
    private static boolean hasCycle(int node, Map<Integer, List<Integer>> adjMap, Set<Integer> visited) {
        if(visited.contains(node)) {
            return true;
        }
        visited.add(node);
        List<Integer> children = adjMap.getOrDefault(node, new ArrayList<>());
        for (int child : children) {
            if (hasCycle(child, adjMap, visited)) {
                return true;
            }
        }
        visited.remove(node);
        return false;
    }




    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        //System.out.print(ArrayChallenge(s.nextLine()));
    }

}