package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CountUnguardedCellsInTheGrid {


    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        for (char[] gr : grid) {
            Arrays.fill(gr, '0');
        }
        for (int[] g : guards) {
            grid[g[0]][g[1]] = 'G';
        }
        for (int[] w : walls) {
            grid[w[0]][w[1]] = 'W';
        }
        //int count = 0;
        for (int[] g : guards) {
            for (int i = g[0] - 1, j = g[1]; i >= 0; i--) {
                if (grid[i][j] != 'W' && grid[i][j] != 'G') {
                    /*if (grid[i][j] == '0') {
                        grid[i][j] = '1';
                        count++;
                    }*/
                    grid[i][j] = '1';
                } else {
                    break;
                }
            }
            for (int i = g[0], j = g[1] - 1; j >= 0; j--) {
                if (grid[i][j] != 'W' && grid[i][j] != 'G') {
                    /*if (grid[i][j] == '0') {
                        grid[i][j] = '1';
                        count++;
                    }*/
                    grid[i][j] = '1';
                } else {
                    break;
                }
            }
            for (int i = g[0] + 1, j = g[1]; i < m; i++) {
                if (grid[i][j] != 'W' && grid[i][j] != 'G') {
                    /*if (grid[i][j] == '0') {
                        grid[i][j] = '1';
                        count++;
                    }*/
                    grid[i][j] = '1';
                } else {
                    break;
                }
            }
            for (int i = g[0], j = g[1] + 1; j < n; j++) {
                if (grid[i][j] != 'W' && grid[i][j] != 'G') {
                    /*if (grid[i][j] == '0') {
                        grid[i][j] = '1';
                        count++;
                    }*/
                    grid[i][j] = '1';
                } else {
                    break;
                }
            }
        }
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    unguardedCount++;
                }
            }
        }
        return unguardedCount;
        //return (m * n) - (guards.length + walls.length + count);
    }


}
