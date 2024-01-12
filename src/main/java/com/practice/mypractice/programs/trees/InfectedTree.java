package com.practice.mypractice.programs.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.practice.mypractice.programs.dto.TreeNode;

public class InfectedTree {

    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        convertToGraph(root);
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        int time = -1;

        while (!queue.isEmpty()) {
            time++;
            for (int i = queue.size(); i > 0; i--) {
                int currNode = queue.pollFirst();
                visited.add(currNode);

                if (adjList.containsKey(currNode)) {
                    for (int neighbour : adjList.get(currNode)) {
                        if (!visited.contains(neighbour)) {
                            queue.offer(neighbour);
                        }
                    }
                }
            }
        }

        return time;
    }

    private void convertToGraph(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            adjList.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.left.val);
            adjList.computeIfAbsent(node.left.val, k -> new ArrayList<>()).add(node.val);
        }
        if (node.right != null) {
            adjList.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.right.val);
            adjList.computeIfAbsent(node.right.val, k -> new ArrayList<>()).add(node.val);
        }

        convertToGraph(node.left);
        convertToGraph(node.right);
    }

}
