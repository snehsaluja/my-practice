package com.practice.mypractice.programs;

public class KnightDialer {

    public static int knightDialer(int n) {
        int count = 0;
        int MOD = 1000000007;

        int[][] allPossibleMoves = new int[][]{
                {4, 6},                         // from 0
                {6, 8},                         // from 1
                {7, 9},                         // from 2
                {4, 8},                         // from 3
                {3, 9, 0},                      // from 4
                {},                             // from 5
                {1, 7, 0},                      // from 6
                {2, 6},                         // from 7
                {1, 3},                         // from 8
                {2, 4}                          // from 9
        };

        int[][] dp = new int[n][10];

        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int move = 1; move < n; move++) {
            for (int num = 0; num < 10; num++) {
                for (int next : allPossibleMoves[num]) {
                    dp[move][num] = (dp[move][num] + dp[move - 1][next]) % MOD;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            count = (count + dp[n - 1][i]) % MOD;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(knightDialer(1));
        System.out.println(knightDialer(2));
        System.out.println(knightDialer(3));
        System.out.println(knightDialer(4));
        System.out.println(knightDialer(5));
        System.out.println(knightDialer(6));
        System.out.println(knightDialer(7));
        System.out.println(knightDialer(8));
        System.out.println(knightDialer(9));
        System.out.println(knightDialer(10));
        System.out.println(knightDialer(11));
        System.out.println(knightDialer(12));
        System.out.println(knightDialer(13));
        System.out.println(knightDialer(3));

    }

/*
    static final int mod = (int) 1e9 + 7;
    static final int[][] MOVES = {
            *//*0*//* {4, 6},
     *//*1*//* {6, 8},
     *//*2*//* {7, 9},
     *//*3*//* {4, 8},
     *//*4*//* {0, 3, 9},
     *//*5*//* {},
     *//*6*//* {0, 1, 7},
     *//*7*//* {2, 6},
     *//*8*//* {1, 3},
     *//*9*//* {2, 4}
    };
    static final int[][] cache = new int[5001][10];

    public int knightDialer(int n) {
        return knightDialer(n, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    int knightDialer(int remaining, int[] nextNumbers) {
        if (remaining == 1) return nextNumbers.length;
        int count = 0;

        for (int nextNumber : nextNumbers) {
            int cur = cache[remaining][nextNumber];
            if (cur == 0) {
                cur = knightDialer(remaining - 1, MOVES[nextNumber]);
                cache[remaining][nextNumber] = cur;
            }
            count += cur;
            count %= mod;
        }
        return count;
    }*/
}
