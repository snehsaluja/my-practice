package com.practice.mypractice.programs;

import java.util.PriorityQueue;

public class ConstructStringWithRepeatLimit {

    public String repeatLimitedString(String s, int repeatLimit) {

        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        outer:
        for (int i = 25; i >= 0; i--) {
            if (freq[i] <= 0)
                continue;
            while (freq[i] > 0) {
                int count = Math.min(freq[i], repeatLimit);
                freq[i] -= Math.min(freq[i], repeatLimit);
                while (count-- > 0) {
                    sb.append((char) (i + 'a'));
                }
                if (freq[i] > 0) {
                    int j = i - 1;
                    for (; j >= 0; j--) {
                        if (freq[j] > 0) {
                            sb.append((char) (j + 'a'));
                            freq[j]--;
                            break;
                        }
                    }
                    if (j < 0) {
                        break outer;
                    }
                }
            }
        }
        return sb.toString();
    }


    public String repeatLimitedString2(String s, int repeatLimit) {
        char[] chArr = new char[s.length()];
        int index = 0;
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        outer:
        for (int i = 25; i >= 0; i--) {
            int j = i - 1;

            while (freq[i] > repeatLimit) {
                for (int k = 0; k < repeatLimit; k++) {
                    chArr[index++] = (char) (i + 'a');
                }
                freq[i] -= repeatLimit;

                while (j >= 0 && freq[j] == 0)
                    j--;
                if (j < 0)
                    break outer;

                chArr[index++] = (char) (j + 'a');
                freq[j]--;
            }
            while (freq[i] > 0) {
                chArr[index++] = (char) (i + 'a');
                freq[i]--;
            }
        }
        return new String(chArr).trim();
    }

    public static void main(String[] args) {
        ConstructStringWithRepeatLimit ob = new ConstructStringWithRepeatLimit();
        System.out.println(ob.repeatLimitedString("cczazcc", 3));
    }
}
