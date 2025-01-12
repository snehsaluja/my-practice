package com.practice.mypractice.programs;

import com.practice.mypractice.programs.parkinglotsystem.dto.ParkingLot;

import java.util.Stack;

public class CheckIfAParenthesesStringCanBeValid {

    // Very good solution:
    // https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/solutions/6267067/simple-balance-2-methods-detailed-solution

    public static boolean canBeValid(String s, String locked) {
        if ((s.charAt(0) == ')' && locked.charAt(0) == '1') || s.length() % 2 == 1)
            return false;

        int n = s.length();
        Stack<Integer> lockedIndices = new Stack<>();
        Stack<Integer> unlockedIndices = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                unlockedIndices.push(i);
            } else if (s.charAt(i) == '(') {
                lockedIndices.push(i);
            } else if (s.charAt(i) == ')') {
                if (!lockedIndices.isEmpty()) {
                    lockedIndices.pop();
                } else if (!unlockedIndices.isEmpty()) {
                    unlockedIndices.pop();
                } else {
                    return false;
                }
            }
        }

        while (!lockedIndices.isEmpty() && !unlockedIndices.isEmpty() && lockedIndices.peek() < unlockedIndices.peek()) {
            lockedIndices.pop();
            unlockedIndices.pop();
        }

        if (lockedIndices.isEmpty() && !unlockedIndices.isEmpty()) {
            return unlockedIndices.size() % 2 == 0;
        }

        return lockedIndices.isEmpty();
    }


    public static boolean canBeValid_twoPass(String s, String locked) {
        int openCount = 0, closedCount = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                openCount++;
            } else {
                openCount--;
            }
        }
        if (openCount < 0) {
            return false;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                closedCount++;
            } else {
                closedCount--;
            }
        }
        if (closedCount < 0) {
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(canBeValid("(()())", "111111"));
    }
}
