package com.practice.mypractice.programs.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindBuildingWhereAliceAndBobCanMeet {

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] result = new int[queries.length];
        int n = heights.length, index = 0;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            adjList.get(i).add(i);
            for (int j = i + 1; j < n; j++) {
                if (heights[j] > heights[i]) {
                    adjList.get(i).add(j);
                }
            }
        }
        for (int[] q : queries) {
            int startA = q[0], startB = q[1];
            
            Set<Integer> set = new HashSet<>(adjList.get(startA));
            boolean found = false;
            for (int i : adjList.get(startB)) {
                if (set.contains(i)) {
                    result[index++] = i;
                    found = true;
                    break;
                }
            }
            if (!found) {
                result[index++] = -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindBuildingWhereAliceAndBobCanMeet ob = new FindBuildingWhereAliceAndBobCanMeet();
        System.out.println(ob.leftmostBuildingQueries(new int[]{6, 4, 8, 5, 2, 7},
                new int[][]{{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}}));
    }
}
