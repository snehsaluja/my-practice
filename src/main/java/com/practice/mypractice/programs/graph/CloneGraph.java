package com.practice.mypractice.programs.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    private Map<Node, Node> clonedNodes = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }
        if (clonedNodes.containsKey(node)) {
            return clonedNodes.get(node);
        }

        Node newNode = new Node(node.val);
        clonedNodes.put(node, newNode);

        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }

        return newNode;
    }

    public Node cloneGraphBFS(Node node) {

        if (node == null)
            return null;

        Map<Node, Node> adjMap = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();

        q.offer(node);
        adjMap.put(node, new Node(node.val));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            Node clonedCurr = adjMap.get(curr);

            for (Node neighbor : curr.neighbors) {
                if (!adjMap.containsKey(neighbor)) {
                    q.offer(neighbor);
                    adjMap.put(neighbor, new Node(neighbor.val));
                }
                clonedCurr.neighbors.add(adjMap.get(neighbor));
            }
        }


        return adjMap.get(node);
    }


}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}