package com.practice.mypractice.interview15;

import java.util.Stack;

public class Question1 {
    // DP
    
/*

2(E) - EE
12(AB)- ABABABABABABA... 12 times

2(A)3(B) = AABBB

2(A2(CDB))          = 2(ABB) = ABBABB

    */


    public static void main(String[] args) {
        //System.out.println(decompress("12(AB)"));
        System.out.println(decompress("121(ABC11(S))"));
        //System.out.println(decompress("3(ABC2(S3(M)))"));
        //System.out.println(decompress("12(ADF)13(SER)"));


        /*
        SER
        13
        ADF
        12
        */
    }

    public static String decompress(String str) {
        StringBuilder sb;
        Stack<String> stack = new Stack<>();
        int times = 0;
        for (char ch : str.toCharArray()) {
            if (ch >= 48 && ch <= 57) {
                times = (times * 10) + (ch - 48);
            } else if (ch == '(') {
                stack.push(String.valueOf(times));
                stack.push(String.valueOf(ch));
                times = 0;
            } else if (ch >= 'A' && ch <= 'Z') {
                stack.push(String.valueOf(ch));
            } else if (ch == ')') {
                sb = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    sb.insert(0, stack.pop());
                }
                stack.pop(); // this will give me '('
                int t = Integer.parseInt(stack.pop());
                StringBuilder sb2 = new StringBuilder(sb);
                while (t > 1) {
                    sb2.append(sb);
                    t--;
                }
                stack.push(sb2.toString());
            }
        }
        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }


}
