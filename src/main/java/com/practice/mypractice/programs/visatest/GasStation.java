package com.practice.mypractice.programs.visatest;

class GasStation {
    public static int canCompleteCircuit(int t, int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) {
            return -1;
        }

        int currentGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        int t1 = 16;
        int[] capacity1 = {2, 5, 6};
        int[] recharge1 = {12, 1, 4};
        System.out.println(canCompleteCircuit(t1, capacity1, recharge1)); // ✅ Expected: 3

        int t2 = 16;
        int[] capacity2 = {2, 5, 6};
        int[] recharge2 = {12, 8, 4};
        System.out.println(canCompleteCircuit(t2, capacity2, recharge2)); // ✅ Expected: -1
    }
}