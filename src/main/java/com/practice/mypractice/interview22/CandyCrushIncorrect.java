package com.practice.mypractice.interview22;
/*

New Relic Coding Round (2nd team):


This question is about implementing a basic elimination algorithm for Candy Crush.
Given a 2D integer array board representing the grid of candy, different positive integers board(il(jl represent different
        types of candies. A value of board[i](j] = 0 represents that
        the cell at position (i, j) is empty. The given board represents the state of the game following the player's move.
        Now, you need to restore the board to a stable state by crushing candies according to the following rules:
        1. If three or more candies of the same type are adjacent vertically or horizontally, "crush" them all at the same time - these positions become empty.
        2. After crushing all candies simultaneously, if an empty space on the board has candies on top of itself,
            then these candies will drop until they hit a candy or bottom at the same time. (No new candies will drop outside the top boundary.)
        3. After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the above steps.
        4. If there does not exist more candies that can be crushed (le. the board is stable), then return the current board.

You need to perform the above rules until the board becomes stable, then return the current board.

Input:
board =
[
[110,   5,    112,  113,    114],
[210,   211,  5,    213,    214],
[310,   311,  3,    313,    314],
[410,   411,  412,  5,      414],
[5,     1,    512,  3,      3],
[610,   4,    1,    613,    614],
[710,   1,    2,    713,    714],
[810,   1,    2,    1,      1],
[1,     1,    2,    2,      2],
[4,     1,    4,    4,      1014]
]

Output:
[
[0,     0,      0,      0,      0],
[0,     0,      0,      0,      0],
[0,     0,      0,      0,      0],
[110,   0,      0,      0,      114],
[210,   0,      0,      0,      214],
[310,   0,      0,      113,    314],
[410,   0,      0,      213,    414],
[610,   211,    112,    313,    614],
(710,   311,    412,    613,    714],
[810,   411,    512,    713,    1014]]

Constraints:

1. The length of board will be in the range [3, 50).
2. The length of board(i] will be in the range [3, 50).
3. Each board|i|(j1 will initially start as an integer in the range [1, 2000].

*/


import lombok.Data;

import java.util.HashSet;
import java.util.Set;

public class CandyCrushIncorrect {

    // This code will remove all neighboring same numbers if the count is 3 irrespective of the shape formed.
    // Example Input:
    // 1 9 8 7 6 5
    // 5 9 9 8 5 2
    // 6 4 3 2 1 9
    //
    // Example Output:
    // 1 '0'  8  7 6 5
    // 5 '0' '0' 8 5 2
    // 6  4   3  2 1 9
    //
    // (which is not how the actual game is)
    // Correct answer is in the class - CandyCrush.java

    private void crush(int[][] board, Set<Pair<Integer, Integer>> crushedSet) {
        //int m = board.length, n = board[0].length;
        for (Pair<Integer, Integer> pair : crushedSet) {
            board[pair.i][pair.j] = -1;
        }
    }

    private Set<Pair<Integer, Integer>> find(int[][] board) {
        int m = board.length, n = board[0].length;
        Set<Pair<Integer, Integer>> crushedSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                boolean dfsValue = false;
                int count = 1;
                if (j + 1 < n && board[i][j] == board[i][j + 1] && board[i][j] != -1 && board[i][j] != 0) {
                    visited[i][j] = true;
                    dfsValue = dfsValue || dfs(board, visited, i, j + 1, crushedSet, count + 1);
                }
                if (i + 1 < m && board[i][j] == board[i + 1][j] && board[i][j] != -1 && board[i][j] != 0) {
                    visited[i][j] = true;
                    dfsValue = dfsValue || dfs(board, visited, i + 1, j, crushedSet, count + 1);
                }
                if (j - 1 >= 0 && board[i][j] == board[i][j - 1] && board[i][j] != -1 && board[i][j] != 0) {
                    visited[i][j] = true;
                    dfsValue = dfsValue || dfs(board, visited, i, j - 1, crushedSet, count + 1);
                }
                if (i - 1 >= 0 && board[i][j] == board[i - 1][j] && board[i][j] != -1 && board[i][j] != 0) {
                    visited[i][j] = true;
                    dfsValue = dfsValue || dfs(board, visited, i - 1, j, crushedSet, count + 1);
                }
                if (dfsValue) {
                    crushedSet.add(new Pair<>(i, j));
                }
            }

        }
        return crushedSet;
    }

    private boolean dfs(int[][] board, boolean[][] visited, int i, int j, Set<Pair<Integer, Integer>> crushedSet, int count) {
        boolean returnVal = false;
        int m = board.length, n = board[0].length;
        if (count >= 3) {
            returnVal = true;
        }
        if (j + 1 < n && board[i][j] == board[i][j + 1] && board[i][j] != -1 && board[i][j] != 0 && !visited[i][j + 1]) {
            visited[i][j] = true;
            returnVal = returnVal || dfs(board, visited, i, j + 1, crushedSet, count + 1);
        }
        if (i + 1 < m && board[i][j] == board[i + 1][j] && board[i][j] != -1 && board[i][j] != 0 && !visited[i + 1][j]) {
            visited[i][j] = true;
            returnVal = returnVal || dfs(board, visited, i + 1, j, crushedSet, count + 1);
        }
        if (j - 1 >= 0 && board[i][j] == board[i][j - 1] && board[i][j] != -1 && board[i][j] != 0 && !visited[i][j - 1]) {
            visited[i][j] = true;
            returnVal = returnVal || dfs(board, visited, i, j - 1, crushedSet, count + 1);
        }
        if (i - 1 >= 0 && board[i][j] == board[i - 1][j] && board[i][j] != -1 && board[i][j] != 0 && !visited[i - 1][j]) {
            visited[i][j] = true;
            returnVal = returnVal || dfs(board, visited, i - 1, j, crushedSet, count + 1);
        }

        if (returnVal) {
            crushedSet.add(new Pair<>(i, j));
        }

        return returnVal;
    }

    private void drop(int[][] board) {
        int m = board.length, n = board[0].length, start = 0, end;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    start = i;
                    end = start;
                    for (int k = start + 1; k < m; k++) {
                        if (board[k][j] == -1) {
                            end = k;
                        } else {
                            break;
                        }
                    }
                    int endIndex = end;
                    for (int k = start - 1; k >= 0; k--) {
                        board[endIndex--][j] = board[k][j];
                    }
                    for (int k = endIndex; k >= 0; k--) {
                        board[k][j] = 0;
                    }
                }
            }
        }
    }

    private void displayBoard(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println("********");
    }

    public int[][] candyCrush(int[][] board) {

        Set<Pair<Integer, Integer>> crushedSet = find(board);
        //System.out.println(crushedSet);
        while (!crushedSet.isEmpty()) {
            crush(board, crushedSet);
            drop(board);
            //displayBoard(board);
            crushedSet = find(board);
        }
        return board;
    }

    public static void main(String[] args) {
        int[][] board = {
                {110, 5, 112, 113, 114},
                {210, 211, 5, 213, 214},
                {310, 311, 3, 313, 314},
                {410, 411, 412, 5, 414},
                {5, 1, 512, 3, 3},
                {610, 4, 1, 613, 614},
                {710, 1, 2, 713, 714},
                {810, 1, 2, 1, 1},
                {1, 1, 2, 2, 2},
                {4, 1, 4, 4, 1014}
        };
        CandyCrushIncorrect ob = new CandyCrushIncorrect();
        ob.candyCrush(board);
    }

}

@Data
class Pair<K, V> {

    K i;
    V j;

    Pair(K k, V v) {
        i = k;
        j = v;
    }
}