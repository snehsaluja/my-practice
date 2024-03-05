package com.practice.mypractice.programs.ubs.practice;

public class EricaBob {

    public static String winner(String erica, String bob) {
        int scoreErica = 0, scoreBob = 0;
        for (int i = 0; i < erica.length(); i++) {
            char chErica = erica.charAt(i);
            char chBob = bob.charAt(i);
            scoreErica += getScore(chErica);
            scoreBob += getScore(chBob);
        }
        if (scoreErica > scoreBob)
            return "Erica";
        else if (scoreErica < scoreBob)
            return "Bob";
        else
            return "Tie";
    }

    private static int getScore(char ch) {
        switch (ch) {
            case 'E':
                return 1;
            case 'M':
                return 2;
            case 'H':
                return 3;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(winner("E","H"));
        System.out.println(winner("EHH","EME"));
    }
}
