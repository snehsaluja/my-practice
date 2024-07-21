package com.practice.mypractice.programs;

public class CompareVersionNumbers {

    public static void main(String[] args) {

    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length && i < v2.length) {
            if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                return 1;
            } else if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                return -1;
            }
            i++;
        }
        if (i < v1.length) {
            while (Integer.parseInt(v1[i]) == 0) {
                i++;
            }
            return (i < v1.length && Integer.parseInt(v1[i]) != 0) ? 1 : -1;
        }
        if (i < v2.length) {
            while (Integer.parseInt(v2[i]) == 0) {
                i++;
            }
            return (i < v2.length && Integer.parseInt(v2[i]) != 0) ? -1 : 1;
        }
        return 0;
    }

    public int compareVersion2(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < v1.length || j < v2.length) {
            int num1 = 0, num2 = 0;
            if (i < v1.length) {
                num1 = Integer.parseInt(v1[i]);
            }
            if (j < v2.length) {
                num2 = Integer.parseInt(v2[i]);
            }
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }
}
