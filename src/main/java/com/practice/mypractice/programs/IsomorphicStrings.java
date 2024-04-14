package com.practice.mypractice.programs;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] freqS = new int[128];
        int[] freqT = new int[128];

        for (int i = 0; i < s.length(); i++) {
            int chS = s.charAt(i);
            int chT = t.charAt(i);
            if (freqS[chS] != freqT[chT])
                return false;
            freqS[chS] = i + 1;
            freqT[chT] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
