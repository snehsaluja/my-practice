package com.practice.mypractice.programs.graph;

public class Max4DigitNumberInMatrix {

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int solution(int[][] board) {
        int maxNumber = 0;
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxNumber = Math.max(maxNumber, findMaxPath(board, i, j));
            }
        }

        return maxNumber;
    }

    private int findMaxPath(int[][] board, int startRow, int startCol) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        return dfs(board, startRow, startCol, 1, ""+board[startRow][startCol], visited);
    }

    private int dfs(int[][] board, int row, int col, int depth, String path, boolean[][] visited) {
        if (depth == 4) {
            return Integer.parseInt(path);
        }

        visited[row][col] = true;
        int maxNumber = 0;

        /*for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && !visited[newRow][newCol]) {
                maxNumber = Math.max(maxNumber, dfs(board, newRow, newCol, depth + 1, path + board[newRow][newCol], visited));
            }

        }*/
        // Move right
        if (col + 1 < board[0].length && !visited[row][col + 1]) {
            maxNumber = Math.max(maxNumber, dfs(board, row, col + 1, depth + 1, path + board[row][col + 1], visited));
        }

        // Move down
        if (row + 1 < board.length && !visited[row + 1][col]) {
            maxNumber = Math.max(maxNumber, dfs(board, row + 1, col, depth + 1, path + board[row + 1][col], visited));
        }

        // Move left
        if (col - 1 >= 0 && !visited[row][col - 1]) {
            maxNumber = Math.max(maxNumber, dfs(board, row, col - 1, depth + 1, path + board[row][col - 1], visited));
        }

        // Move up
        if (row - 1 >= 0 && !visited[row - 1][col]) {
            maxNumber = Math.max(maxNumber, dfs(board, row - 1, col, depth + 1, path + board[row - 1][col], visited));
        }

        visited[row][col] = false;
        return maxNumber;
    }

    public static void main(String[] args) {
        Max4DigitNumberInMatrix obj = new Max4DigitNumberInMatrix();
        int[][] board = {
                {9, 1, 1, 0, 7},
                {1, 0, 2, 1, 0},
                {1, 9, 1, 1, 0}
        };
        obj.testMySolution(board);// Output should be 9121

        obj.testMySolution(new int[][]{
                {9, 1, 1, 0, 7},
                {1, 0, 2, 1, 0},
                {1, 3, 1, 1, 0}
        });// Output should be 9113

        obj.testMySolution(new int[][]{
                {4, 1, 1, 0, 7},
                {1, 0, 2, 1, 0},
                {1, 3, 1, 1, 0}
        });// Output should be 7012

        obj.testMySolution(new int[][]{
                {4, 1, 1, 0, 9},
                {1, 0, 2, 1, 0},
                {1, 3, 1, 1, 0}
        });// Output should be 9012

        obj.testMySolution(new int[][]{
                {9, 1, 1, 0, 9},
                {1, 0, 2, 1, 0},
                {1, 3, 1, 1, 0}
        });// Output should be 9113

        obj.testMySolution(new int[][]{
                {5, 0, 3, 0, 3},
                {1, 0, 8, 4, 0},
                {3, 3, 2, 1, 6}
        });// Output should be 8416
        obj.testMySolution(new int[][]{
                {0, 1},
                {2, 3},
                {4, 5},
                {6, 7},
                {8, 9}
        });// Output should be 9867
    }

    private void testMySolution(int[][] board) {
        System.out.println(solution(board));

    }
}