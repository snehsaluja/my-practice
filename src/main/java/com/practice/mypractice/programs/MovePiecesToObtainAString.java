package com.practice.mypractice.programs;

public class MovePiecesToObtainAString {

    public static void main(String[] args) {

    }

    public boolean canChange(String start, String target) {
        char[] s = start.toCharArray();
        char[] t = target.toCharArray();
        int i = 0, j = 0, n = start.length();
        while (i < n || j < n) {
            while (i < n && s[i] == '_') {
                i++;
            }

            while (j < n && t[j] == '_') {
                j++;
            }

            if (i == n || j == n)
                break;

            if (s[i] != t[j]) {
                return false;
            }

            if (s[i] == 'L' && i < j) {
                return false;
            }

            if (s[i] == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
        return i == n && j == n;
    }
}
