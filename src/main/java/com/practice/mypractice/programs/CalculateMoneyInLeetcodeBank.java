package com.practice.mypractice.programs;

public class CalculateMoneyInLeetcodeBank {

    public int totalMoney(int n) {
        //int sum = 0, k = 1, j = 1;
        int sum1, sum2, sum3, sum4, sum5, sum6, sum7, fullWeeks = n / 7, remainingDays = n % 7;
        sum1 = (2 * 1 + ((fullWeeks + ((remainingDays) > 0 ? 1 : 0)) - 1)) * (fullWeeks + ((remainingDays) > 0 ? 1 : 0)) / 2;
        sum2 = (2 * 2 + ((fullWeeks + ((remainingDays) > 1 ? 1 : 0)) - 1)) * (fullWeeks + ((remainingDays) > 1 ? 1 : 0)) / 2;
        sum3 = (2 * 3 + ((fullWeeks + ((remainingDays) > 2 ? 1 : 0)) - 1)) * (fullWeeks + ((remainingDays) > 2 ? 1 : 0)) / 2;
        sum4 = (2 * 4 + ((fullWeeks + ((remainingDays) > 3 ? 1 : 0)) - 1)) * (fullWeeks + ((remainingDays) > 3 ? 1 : 0)) / 2;
        sum5 = (2 * 5 + ((fullWeeks + ((remainingDays) > 4 ? 1 : 0)) - 1)) * (fullWeeks + ((remainingDays) > 4 ? 1 : 0)) / 2;
        sum6 = (2 * 6 + ((fullWeeks + ((remainingDays) > 5 ? 1 : 0)) - 1)) * (fullWeeks + ((remainingDays) > 5 ? 1 : 0)) / 2;
        sum7 = (2 * 7 + ((fullWeeks) - 1)) * (fullWeeks) / 2;
        return sum1 + sum2 + sum3 + sum4 + sum5 + sum6 + sum7;
    }

    public static int totalMoney2(int n) {
        int fullWeeks = n / 7, remainingDays = n % 7;
        int sum = (int) (((2 * 28) + (fullWeeks - 1) * 7) * ((double)fullWeeks / 2));
        sum += (2 * (fullWeeks + 1) + (remainingDays - 1)) * ((double)remainingDays / 2);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(totalMoney2(10));
    }
}
