package com.practice.mypractice.programs;

public class ValidWord {

    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }

        boolean vowelPresent = false, consonantPresent = false;
        for (char ch : word.toCharArray()) {
            if (!isAlphanumeric(ch)) {
                return false;
            }
            vowelPresent = vowelPresent | isVowel(ch);
            consonantPresent = consonantPresent | isConsonant(ch);
        }

        return vowelPresent && consonantPresent;
    }

    private boolean isConsonant(char ch) {
        return !(ch >= 48 && ch <= 57) && !isVowel(ch);
    }

    private boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }

    private static boolean isAlphanumeric(char ch) {
        return (ch >= 48 && ch <= 57) || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public static void main(String[] args) {

    }
}
