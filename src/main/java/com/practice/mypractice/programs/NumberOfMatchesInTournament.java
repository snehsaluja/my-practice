package com.practice.mypractice.programs;

public class NumberOfMatchesInTournament {
    public static int numberOfMatches(int n) {
        return find(n);
    }

    private static int find(int n) {
        if (n == 1) {
            return 0;
        }
        return n / 2 + find(n / 2 + n % 2);
    }


    public static int numberOfMatchesMOSTOPTIMIZED(int n) {
        return n - 1;
    }

    public static void main(String[] args) {

        System.out.println(numberOfMatches(8));
        System.out.println(numberOfMatches(6));
        System.out.println(numberOfMatches(5));
        System.out.println(numberOfMatches(9));
        System.out.println(numberOfMatches(32));
        System.out.println("==================================");
        System.out.println(numberOfMatchesMOSTOPTIMIZED(8));
        System.out.println(numberOfMatchesMOSTOPTIMIZED(6));
        System.out.println(numberOfMatchesMOSTOPTIMIZED(5));
        System.out.println(numberOfMatchesMOSTOPTIMIZED(9));
        System.out.println(numberOfMatchesMOSTOPTIMIZED(32));
    }
}
