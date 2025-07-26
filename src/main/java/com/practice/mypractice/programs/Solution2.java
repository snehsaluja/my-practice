package com.practice.mypractice.programs;

import java.util.*;

public class Solution2 {
    private static final int WIDTH = 15;
    private static final int HEIGHT = 10;
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Right, Down, Left, Up

    public static String extractPath(List<String> gridMap) {
        StringBuilder result = new StringBuilder();
        boolean[][] visited = new boolean[HEIGHT][WIDTH];
        int x = 0, y = 0;

        // Follow the path
        while (true) {
            char current = gridMap.get(y).charAt(x);
            if (Character.isLowerCase(current)) {
                result.append(current);
            }
            visited[y][x] = true;

            boolean moved = false;
            for (int[] dir : DIRECTIONS) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (isValidMove(newX, newY, gridMap, visited)) {
                    x = newX;
                    y = newY;
                    moved = true;
                    break;
                }
            }
            if (!moved) break; // End of path
        }

        return result.toString();
    }

    private static boolean isValidMove(int x, int y, List<String> grid, boolean[][] visited) {
        return x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT && !visited[y][x] &&
                (grid.get(y).charAt(x) == '*' || Character.isLowerCase(grid.get(y).charAt(x)));
    }

    public static void main(String[] args) {
        List<String> grid = Arrays.asList(
                "***             ",
                "  *             ",
                "  *             ",
                "  **c**od**i**  ",
                "             *  ",
                "    e        *  ",
                "    *        n  ",
                "    **m*a*g***  ",
                "                ",
                "                "
        );

        System.out.println(extractPath(grid)); // Output: "codingame"
    }
}
