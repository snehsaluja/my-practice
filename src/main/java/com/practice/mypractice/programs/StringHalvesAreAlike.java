package com.practice.mypractice.programs;

public class StringHalvesAreAlike {

    public boolean halvesAreAlike(String s) { // Complexity is O(n) , but takes 3 ms

        int len = s.length(), counter = 0;

        for (int i = 0; i < len / 2; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                counter++;
            }
        }
        for (int i = len / 2; i < len; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                counter--;
            }
        }

        return counter == 0;
    }

    public boolean halvesAreAlikeFaster(String s) {     // this is faster in LeetCode's runner = 1ms. though Complexity is O(n)
        int mid = s.length() / 2;
        String a = s.substring(0, mid), b = s.substring(mid);
        return countVowels(a) == countVowels(b);
    }

    private int countVowels(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (isVowel(ch))
                count++;
        }

        /* for (char ch : str.toCharArray()) {
            if ("AEIOUaeiou".indexOf(ch) != -1) {
                count++;
            }
        }*/
        return count;
    }


    private boolean isVowel(char ch) {
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
        /*if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' ||  ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I'|| ch == 'O' ||  ch == 'U')
            return true;
        else
            return false;*/
    }

    public static void main(String[] args) {

    }
}
