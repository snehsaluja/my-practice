package com.practice.mypractice.programs;

public class ValidPalindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindromeMemoryOptimized("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindromeMemoryOptimized(String s) {
        s = s.trim();
        int st = 0, end = s.length() - 1;
        while (st <= end) {
            char ch1 = s.charAt(st), ch2 = s.charAt(end);
            if (!((ch1 >= 'a' && ch1 <= 'z') || (ch1 >= '0' && ch1 <= '9') || (ch1 >= 'A' && ch1 <= 'Z'))) {
                st++;
                continue;
            } else if (ch1 >= 'A' && ch1 <= 'Z') {
                ch1 = (char) (ch1 + 32);
            }

            if (!((ch2 >= 'a' && ch2 <= 'z') || (ch2 >= '0' && ch2 <= '9') || (ch2 >= 'A' && ch2 <= 'Z'))) {
                end--;
                continue;
            } else if (ch2 >= 'A' && ch2 <= 'Z') {
                ch2 = (char) (ch2 + 32);
            }
            if (ch1 != ch2) {
                return false;
            }
            st++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                sb.append(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                sb.append((char) (ch + 32));
            }
        }

        int st = 0, end = sb.length() - 1;
        while (st <= end) {
            if (sb.charAt(st) != sb.charAt(end)) {
                return false;
            }
            st++;
            end--;
        }
        System.out.println(sb);
        return true;
    }
}
