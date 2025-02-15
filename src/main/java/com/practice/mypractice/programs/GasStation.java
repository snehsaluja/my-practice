package com.practice.mypractice.programs;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentGas = 0, start = 0, totalGas = 0, totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            currentGas += (gas[i] - cost[i]);
            totalGas += gas[i];
            totalCost += cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }

        }
        return (totalGas < totalCost) ? -1 : start;
    }

    public static void main(String[] args) {

    }

}
