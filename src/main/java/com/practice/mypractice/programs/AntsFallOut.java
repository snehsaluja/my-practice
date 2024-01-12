package com.practice.mypractice.programs;

public class AntsFallOut {

    public static void main(String[] args) {

        int n = 4, left[] = {4, 3}, right[] = {0, 1};
        AntsFallOut ob = new AntsFallOut();
        System.out.println(ob.getLastMoment(n, left, right));
    }

    public int getLastMoment(int n, int[] left, int[] right) {

        int leftMax = left.length == 0 ? 0 : left[left.length - 1];
        int rightMin = right.length == 0 ? 0 : right[0];

        /*
        int sum = (leftMostAnt + rightMostAnt);
        int midForRight = sum / 2;
        int midForLeft = (sum % 2 == 0 ? sum : sum + 1) / 2;
        int rightMovement = ((midForRight - rightMostAnt) + midForRight) + (midForLeft == midForRight ? 0 : 1);
        int leftMovement = ((leftMostAnt - midForLeft) + (n - midForLeft) + (midForLeft == midForRight ? 0 : 1));
        */

        return Math.max(leftMax, n-rightMin);
    }
}