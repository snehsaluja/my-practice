package com.practice.mypractice.programs;

public class ValidAnagram {

    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        int[] alphabets = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            alphabets[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            alphabets[ch - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabets[i] != 0)
                return false;
        }
        return true;
    }

}
