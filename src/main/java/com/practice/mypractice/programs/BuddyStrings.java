package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BuddyStrings {
    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        byte[] sBytes = s.getBytes();
        byte[] goalBytes = goal.getBytes();

        if (s.equals(goal)) {
            Set<Byte> set = new HashSet<>();
            for (byte b : sBytes) {
                set.add(b);
            }
            return (set.size() < sBytes.length) ;
        }

        int i = 0, j = s.length() - 1;
        while (i < s.length() && sBytes[i] == goalBytes[i]) {
            i++;
        }
        while (j >= 0 && sBytes[j] == goalBytes[j]) {
            j--;
        }
        if (i < j) {
            byte temp = sBytes[i];
            sBytes[i] = sBytes[j];
            sBytes[j] = temp;
        }
        return Arrays.equals(sBytes, goalBytes);
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("ab","ab"));
    }
}
