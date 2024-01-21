package com.practice.mypractice.programs;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.substring(lastIndex).length();
    }

    public static void main(String[] args) {

    }
}
