package com.practice.mypractice.programs;

public class RotateString {

    public boolean rotateString_bestSolution(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        return (s + s).contains(goal);
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        StringBuilder sb = new StringBuilder(goal);
        int n = goal.length();
        for (int i = 0; i < n; i++) {
            if (sb.toString().equals(s)) {
                return true;
            }
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
