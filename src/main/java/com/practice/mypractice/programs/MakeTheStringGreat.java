package com.practice.mypractice.programs;

public class MakeTheStringGreat {

    public static String makeGood(String s) {
        StringBuilder sb2 = new StringBuilder(s);
        boolean modifiable = true;
        while (sb2.length() > 0 && modifiable) {
            StringBuilder sb = new StringBuilder();
            modifiable = false;
            for (int i = 0; i < sb2.length(); i++) {
                if (i < sb2.length() - 1 && Math.abs(sb2.charAt(i) - sb2.charAt(i + 1)) == 32) {
                    i++;
                    modifiable = true;
                    continue;
                }
                sb.append(sb2.charAt(i));
            }
            sb2 = sb;
        }
        return sb2.toString();
    }

    public static String makeGoodOptimized(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            char peek = sb.length() > 0 ? sb.charAt(sb.length() - 1) : 0;
            if (Math.abs(peek - ch) == 32) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(makeGood("leEeetcode"));
        System.out.println(makeGoodOptimized("leEeetcode"));
        System.out.println(makeGoodOptimized("JTqEfAlhEfR"));
    }
}
