package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.Stack;

public class RotatingTheBox {

    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] output = new char[n][m];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < m; i++) {
            int emptyCellCount = 0, rotatedBoxiIndex = 0, rotatedBoxjIndex = (m - i - 1);
            for (int j = 0; j < n; j++) {
                if (box[i][j] == '*') {
                    // start popping from stack
                    while (emptyCellCount > 0) {
                        output[rotatedBoxiIndex][rotatedBoxjIndex] = '.';
                        emptyCellCount--;
                        rotatedBoxiIndex++;
                    }
                    while (rotatedBoxiIndex < n && !stack.isEmpty()) {
                        output[rotatedBoxiIndex][rotatedBoxjIndex] = (char) stack.pop();
                        rotatedBoxiIndex++;
                    }
                    output[rotatedBoxiIndex++][rotatedBoxjIndex] = '*';
                } else if (box[i][j] == '.') {
                    emptyCellCount++;
                } else {
                    stack.push(box[i][j]);
                }
            }
            while (emptyCellCount > 0) {
                output[rotatedBoxiIndex][rotatedBoxjIndex] = '.';
                emptyCellCount--;
                rotatedBoxiIndex++;
            }
            while (rotatedBoxiIndex < n && !stack.isEmpty()) {
                output[rotatedBoxiIndex][rotatedBoxjIndex] = stack.pop();
                rotatedBoxiIndex++;
            }
        }

        return output;
    }


    public static char[][] rotateTheBoxOptimized(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] ans = new char[n][m];

        for (int i = 0; i < m; i++) {
            int l = n - 1, r = n - 1;
            char[] b = box[i];
            while (l >= 0) {
                if (b[l] == '.') {
                    l--;
                } else if (b[l] == '#') {
                    char temp = b[r];
                    b[r] = b[l];
                    b[l] = temp;
                    l--;
                    r--;
                } else {
                    l--;
                    r = l;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][m - i - 1] = box[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        char[][] box = {{'#', '.', '*', '.' }, {'#', '#', '*', '.' }};
        char[][] ans = rotateTheBoxOptimized(box);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}

/*

Original Matrix:
        0,0     0,1     0,2     0,3     0,4
        1,0     1,1     1,2     1,3     1,4
        2,0     2,1     2,2     2,3     2,4


Rotated Matrix:
        2,0(0,0)     1,0(0,1)     0,0(0,2)
        2,1(1,0)     1,1(1,1)     0,1(1,2)
        2,2(2,0)     1,2(2,1)     0,2(2,2)
        2,3(3,0)     1,3(3,1)     0,3(3,2)
        2,4(4,0)     1,4(4,1)     0,4(4,2)

*/
