package com.practice.mypractice.programs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {

        int[][] directions = {
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4},
                {1, 3, 5},
                {2, 4}};

        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String input = sb.toString();

        if (input.equals(target))
            return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(input);
        visited.add(input);
        int moves = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String current = q.poll();

                if (current.equals(target)) {
                    return moves;
                }
                int zeroPos = current.indexOf('0');
                int[] dirToMove = directions[zeroPos];
                for (int dir : dirToMove) {
                    String nextState = swap(current, zeroPos, dir);
                    if (!visited.contains(nextState)) {
                        q.offer(nextState);
                        visited.add(nextState);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    private String swap(String current, int zeroPos, int dir) {
        char[] charArr = current.toCharArray();
        char temp = charArr[zeroPos];
        charArr[zeroPos] = charArr[dir];
        charArr[dir] = temp;
        return new String(charArr);
    }

    public static void main(String[] args) {

    }
}
