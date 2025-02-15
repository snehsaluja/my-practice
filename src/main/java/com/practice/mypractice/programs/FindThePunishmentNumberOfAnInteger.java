package com.practice.mypractice.programs;

public class FindThePunishmentNumberOfAnInteger {

    public int punishmentNumber(int n) {
        int punishmentNumber = 0;
        for (int i = 1; i <= n; i++) {
            int sq = i * i;
            boolean isPartitionable = isPartitionable(sq, i);
            if (isPartitionable) {
                punishmentNumber += sq;
            }
        }
        return punishmentNumber;
    }

    private boolean isPartitionable(int sq, int n) {
        if (sq < n || n < 0) {
            return false;
        }
        if (sq == n) {
            return true;
        }
        return isPartitionable(sq / 10, n - sq % 10) ||
                isPartitionable(sq / 100, n - sq % 100) ||
                isPartitionable(sq / 1000, n - sq % 1000);
    }

    public static void main(String[] args) {
        FindThePunishmentNumberOfAnInteger ob = new FindThePunishmentNumberOfAnInteger();
        System.out.println(ob.punishmentNumber(10));
    }
}
