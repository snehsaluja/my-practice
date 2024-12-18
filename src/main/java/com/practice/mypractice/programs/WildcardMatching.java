package com.practice.mypractice.programs;

public class WildcardMatching {

    public static void main(String[] args) {

    }

    public boolean isMatchDPApproach(String s, String p) {
        int strLen = s.length(), patLen = p.length();
        boolean[][] match = new boolean[strLen + 1][patLen + 1];
        match[0][0] = true;
        for (int j = 1; j < patLen + 1; j++) {
            if (p.charAt(j - 1) == '*')
                match[0][j] = match[0][j - 1];
        }
        for (int sIndx = 1; sIndx < strLen + 1; sIndx++) {
            for (int pIndx = 1; pIndx < patLen + 1; pIndx++) {
                if (s.charAt(sIndx - 1) == p.charAt(pIndx - 1) || p.charAt(pIndx - 1) == '?') {
                    match[sIndx][pIndx] = match[sIndx - 1][pIndx - 1];
                } else if (p.charAt(pIndx - 1) == '*') {
                    match[sIndx][pIndx] = match[sIndx][pIndx - 1] || match[sIndx - 1][pIndx];
                }
            }
        }
        return match[strLen][patLen];
    }

    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, m = s.length(), n = p.length();
        int startIndex = -1, matchIndex = -1;

        while (i < m) {
            if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < n && p.charAt(j) == '*') {
                startIndex = j;
                matchIndex = i;
                j++;
            } else if (startIndex != -1) {
                j = startIndex + 1;
                matchIndex++;
                i = matchIndex;
            } else {
                return false;
            }
        }
        while (j < n && p.charAt(j) == '*') {
            j++;
        }
        return j == n;
    }
}
