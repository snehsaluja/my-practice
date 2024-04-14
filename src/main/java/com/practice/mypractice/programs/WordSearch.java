package com.practice.mypractice.programs;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean result = false;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = result || search(board, i, j, word, 0, visited);
                }
            }
        }

        return result;
    }

    private boolean search(char[][] board, int i, int j, String word, int k, boolean[][] visited) {
        int m = board.length, n = board[0].length;
        if (k == word.length() - 1) {
            return true;
        }
        boolean result = false;
        visited[i][j] = true;
        if (i < m - 1 && !visited[i + 1][j] && board[i + 1][j] == word.charAt(k + 1)) {
            result = result || search(board, i + 1, j, word, k + 1, visited);
        }
        if (j < n - 1 && !visited[i][j + 1] && board[i][j + 1] == word.charAt(k + 1)) {
            result = result || search(board, i, j + 1, word, k + 1, visited);
        }
        if (i > 0 && !visited[i - 1][j] && board[i - 1][j] == word.charAt(k + 1)) {
            result = result || search(board, i - 1, j, word, k + 1, visited);
        }
        if (j > 0 && !visited[i][j - 1] && board[i][j - 1] == word.charAt(k + 1)) {
            result = result || search(board, i, j - 1, word, k + 1, visited);
        }
        visited[i][j] = false;
        return result;
    }


    // Not optimized attempt :
    public boolean existNotOptimizedAttempt(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (searchNotOptimizedAttempt(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchNotOptimizedAttempt(char[][] board, int i, int j, String word, int k, boolean[][] visited) {
        int m = board.length, n = board[0].length;

        if (k == word.length()) {
            return true;
        }
        if ((i < 0 || i >= m) || (j < 0 || j >= n) || visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(k))
            return false;


        visited[i][j] = true;

        boolean result = searchNotOptimizedAttempt(board, i + 1, j, word, k + 1, visited)
                || searchNotOptimizedAttempt(board, i, j + 1, word, k + 1, visited)
                || searchNotOptimizedAttempt(board, i - 1, j, word, k + 1, visited)
                || searchNotOptimizedAttempt(board, i, j - 1, word, k + 1, visited);

        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {

    }
}
