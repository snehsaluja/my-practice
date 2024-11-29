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


import java.util.HashSet;
import java.util.Set;

public class CandyCrushOptimized {


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

        int m = board.length, n = board[0].length;
        displayBoard(board);
        boolean done = false;
        while (!done) {
            // Find and Crush Rows
            done = true;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n - 2; j++) {
                    int num = Math.abs(board[i][j]);
                    int num1 = Math.abs(board[i][j + 1]);
                    int num2 = Math.abs(board[i][j + 2]);
                    if (num == num1 && num1 == num2 && num != 0 /*&& num > 0*/) {
                        board[i][j] = -num;
                        board[i][j + 1] = -num1;
                        board[i][j + 2] = -num2;
                        done = false;
                    }
                }
            }
            // Find and Crush Cols
            for (int i = 0; i < m - 2; i++) {
                for (int j = 0; j < n; j++) {
                    int num = Math.abs(board[i][j]);
                    int num1 = Math.abs(board[i + 1][j]);
                    int num2 = Math.abs(board[i + 2][j]);
                    if (num == num1 && num1 == num2 && num != 0 /*&& num > 0*/) {
                        board[i][j] = -num;
                        board[i + 1][j] = -num1;
                        board[i + 2][j] = -num2;
                        done = false;
                    }
                }
            }
            // Drop = Gravity
            for (int j = 0; j < n; j++) {
                int index = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (board[i][j] > 0) {
                        board[index][j] = board[i][j];
                        index--;
                    }
                }
                for (int i = index; i >= 0; i--) {
                    board[i][j] = 0;
                }
            }
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
        CandyCrushOptimized ob = new CandyCrushOptimized();
        ob.candyCrush(board);
    }

}
