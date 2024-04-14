package com.practice.mypractice.interview14;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Wayfair round 1


// All In The Family:

// Suppose we have input data describing relationships between parents and children over multiple generations.
// The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

// For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

//            10
//           /
//      1   2     4
//       \ /     / \
//        3     5   8
//         \   / \   \
//          \ /   \   \
//           6     7   9

// Write a function that, for a given individual in our dataset,
// returns their earliest known ancestor – the one at the farthest distance from the input individual.
// If there is more than one ancestor tied for “earliest”, return any one of them.
// If the input individual has no parents, the function should return null (or -1).

// Sample input and output:

// parentChildPairs = [[1, 3], [2, 3], [3, 6], [5, 6], [5, 7], [4, 5], [4, 8], [8, 9], [10,2]];

// 8 => 4

// 7 => 4

// 6 => 10


public class Question_2 {

    static int findParent(int[][] relationship, int child) {

        Map<Integer, List<Integer>> relationMap = new HashMap<>();

        for (int[] rel : relationship) {
            relationMap.computeIfAbsent(rel[1], k -> new ArrayList<>()).add(rel[0]);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(child);
        int parent = child;
        while (!queue.isEmpty()) {
            parent = queue.poll();
            if (relationMap.containsKey(parent)) {
                List<Integer> parents = relationMap.get(parent);
                for (int p : parents) {
                    queue.offer(p);
                }
            }
        }

        return (parent == child) ? -1 : parent;
    }

    public static void main(String[] args) {
        int[][] parentChildPairs = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 9}, {10, 2}};
        System.out.println(findParent(parentChildPairs, 6));
        System.out.println(findParent(parentChildPairs, 7));
        System.out.println(findParent(parentChildPairs, 8));
        System.out.println(findParent(parentChildPairs, 1));
        System.out.println(findParent(parentChildPairs, 9));
    }
}
