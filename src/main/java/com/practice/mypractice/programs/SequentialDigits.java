package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {


    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int totalDigits = getNumberOfDigits(low);
        int i = 1, d = 1, c = 2;
        while (d < totalDigits) {
            i = i * 10 + c++;
            d++;
        }
        while (i <= high) {
            if (i >= low) {
                ans.add(i);
            }
            if (i % 10 == 9) {
                i = 1;
                d = 1;
                c = 2;
                totalDigits++;
                while (d < totalDigits) {
                    i = i * 10 + c++;
                    d++;
                }
            } else {
                int digits = totalDigits;
                while (digits > 1) {
                    i += Math.pow(10, --digits);
                }
                i++;
            }
        }
        return ans;
    }

    public List<Integer> sequentialDigits2(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            int nextDigit = i+1, num = i;
            while (num <= high && nextDigit <= 9) {
                num = num * 10 + nextDigit++;
                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }


    private int getNumberOfDigits(int num) {
        int digits = 0;
        while (num > 0) {
            digits++;
            num /= 10;
        }
        return digits;
    }

    private boolean isSequential(int num) {
        int prev = num % 10, curr;
        num = num / 10;
        while (num > 0) {
            curr = num % 10;
            if (prev - curr != 1) {
                return false;
            }
            prev = curr;
            num /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        SequentialDigits sd = new SequentialDigits();
        System.out.println(sd.sequentialDigits(100, 300));
        System.out.println(sd.sequentialDigits(10, 1000000000));
        System.out.println(sd.sequentialDigits2(100, 300));
        System.out.println(sd.sequentialDigits2(10, 1000000000));
    }
}
