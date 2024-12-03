package com.practice.mypractice.programs;

public class ReverseWordsInAString_Practice {

    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder output = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            output.append(words[i]);
            output.append(" ");
        }
        return output.toString().trim();
    }

    public static void main(String[] args) {

    }

}
