package com.practice.mypractice.programs;

public class RotateString {

    public static boolean rotateString_bestSolution(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        return (s + s).contains(goal);
    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        StringBuilder sb = new StringBuilder(goal);
        int n = goal.length();
        for (int i = 0; i < n; i++) {
            if (sb.toString().equals(s)) {
                return true;
            }
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }

        return false;
    }

    public static String leftRotate(String s, int d) {
        return s.substring(d) + s.substring(0, d);
    }

    public static String rightRotate(String s, int d) {
        int len = s.length();

        //return s.substring(len - d) + s.substring(0, len - d);
        // OR :
        return leftRotate(s, len - d);
    }

    public static void main(String[] args) {
        String str1 = "GeeksforGeeks";
        System.out.println(leftRotate(str1, 2));

        String str2 = "GeeksforGeeks";
        System.out.println(rightRotate(str2, 2));

        System.out.println(rotateString(str2, "forGeeksGeeks"));
        System.out.println(rotateString(str2, "orGeeksGekesf"));
    }
}
