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

    public static String leftRotate_method2(String s, int d) {
        String temp = s + s;
        return temp.substring(d, d + s.length());
    }

    public static String rightRotate_method2(String s, int d) {
        int len = s.length();

        //return s.substring(len - d) + s.substring(0, len - d);
        // OR :
        return leftRotate_method2(s, len - d);
    }

    public static String leftRotate_method3(String s, int d) {
        int len = s.length();
        d = d % len;
        char[] arr = s.toCharArray();
        swap(arr, 0, d - 1);
        swap(arr, d, len - 1);
        swap(arr, 0, len - 1);
        return new String(arr);
    }

    private static void swap(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        String str1 = "GeeksforGeeks";
        System.out.println(leftRotate(str1, 2));

        String str2 = "GeeksforGeeks";
        System.out.println(rightRotate(str2, 2));

        System.out.println(rotateString(str2, "forGeeksGeeks"));
        System.out.println(rotateString(str2, "orGeeksGekesf"));

        System.out.println(leftRotate_method2(str1, 2));
        System.out.println(rightRotate_method2(str1, 2));

        System.out.println(leftRotate_method3(str1, 2));
    }
}
