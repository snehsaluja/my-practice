package com.practice.mypractice.programs;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            freq[ch - 'a']--;
            if (freq[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] lastIndex = new int[26];
        for (char ch : ransomNote.toCharArray()) {
            int indexOf = magazine.indexOf(ch, lastIndex[ch - 'a']);
            if (indexOf == -1)
                return false;
            lastIndex[ch - 'a'] = indexOf + 1;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
