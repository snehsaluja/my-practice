package com.practice.mypractice.programs;

public class AddingSpacesToAString {

    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int space : spaces) {
            sb.append(s.substring(start, space));
            sb.append(" ");
            start = space;
        }
        sb.append(s.substring(start));
        return sb.toString();
    }

    public String addSpaces2(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (index < spaces.length && i == spaces[index]) {
                sb.append(" ");
                index++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String addSpaces3(String s, int[] spaces) {
        int n = s.length(), m = spaces.length;
        char[] ch = new char[n + m];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i == spaces[j]) {
                ch[i + j] = ' ';
                j++;
            }
            ch[i + j] = s.charAt(i);
        }
        return new String(ch);
    }

    public String addSpaces4(String s, int[] spaces) {
        int n = s.length(), m = spaces.length, j = 0;
        char[] ch = new char[n + m];
        char[] sChar = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (j < m && i == spaces[j]) {
                ch[i + j] = ' ';
                j++;
            }
            ch[i + j] = sChar[i];
        }
        return new String(ch);
    }

    public String addSpaces5(String s, int[] spaces) {
        int n = s.length(), m = spaces.length, i = 0, j = 0;
        char[] ch = new char[n + m];
        char[] sChar = s.toCharArray();
        for (int sp : spaces) {
            while (j < sp) {
                ch[i++] = sChar[j++];
            }
            ch[i++] = ' ';
        }
        while (j < n) {
            ch[i++] = sChar[j++];
        }
        return new String(ch);
    }

    public static void main(String[] args) {

    }
}
