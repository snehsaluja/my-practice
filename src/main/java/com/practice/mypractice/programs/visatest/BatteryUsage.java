package com.practice.mypractice.programs.visatest;

import java.util.*;

public class BatteryUsage {
    static class Battery {
        int capacity, recharge;
        int remaining; // How many minutes left before depletion
        int availableAt;

        Battery(int capacity, int recharge) {
            this.capacity = capacity;
            this.recharge = recharge;
            this.remaining = 0;
            this.availableAt = 0;
        }
    }

    public static int solu(int t, int[] capacity, int[] recharge) {

        int time = 0;
        int usedBatteryCount = 0;
        int n = capacity.length;
        Battery[] batteries = new Battery[n];
        for (int i = 0; i < n; i++) {
            batteries[i] = new Battery(capacity[i], recharge[i]);
        }

        while (time < t) {
            for (int i = 0; i < n; i++) {
                if (batteries[i].availableAt <= time && batteries[i].remaining == 0) {
                }
            }
        }

        return -1;
    }

    public static int solution_old(int t, int[] capacity, int[] recharge) {
        int n = capacity.length;
        Battery[] batteries = new Battery[n];
        for (int i = 0; i < n; i++) {
            batteries[i] = new Battery(capacity[i], recharge[i]);
        }

        int time = 0;
        int usedBatteryCount = 0;

        // A set to track used batteries
        Set<Integer> used = new HashSet<>();

        while (time < t) {
            int best = -1;

            for (int i = 0; i < n; i++) {
                if (batteries[i].availableAt <= time && batteries[i].remaining == 0) {
                    // if (best == -1 || capacity[i] > capacity[best]) {
                    best = i;
                    break;
                    //}
                }
            }

            if (best == -1) return -1;

            // Use this battery
            batteries[best].remaining = batteries[best].capacity;
            batteries[best].availableAt = time + batteries[best].capacity + batteries[best].recharge;
            if (batteries[best].remaining + time <= t)
                usedBatteryCount++;

            // Now consume minute by minute from this battery
            while (batteries[best].remaining > 0 && time < t) {
                batteries[best].remaining--;
                time++;
            }
        }

        return usedBatteryCount;
    }

    public static int solution(int t, int[] capacity, int[] recharge) {
        int n = capacity.length;
        // This array will store the absolute time when each battery will become available again.
        // Initially, all batteries are available, so their availability time is 0.
        long[] batteryAvailableTime = new long[n];

        long currentTime = 0; // Current simulated time
        int batteriesUsedCount = 0;
        int currentBatteryPointer = 0; // The index of the battery we try to use next (cyclically)

        while (t > 0) {
            // Find the next available battery, starting from currentBatteryPointer
            int startSearchIndex = currentBatteryPointer;
            int foundBatteryIndex = -1;
            long earliestRechargeCompletionTime = Long.MAX_VALUE;

            // Loop through all batteries to find an available one or the soonest one to be available
            for (int i = 0; i < n; i++) {
                int batteryToConsider = (startSearchIndex + i) % n;

                if (batteryAvailableTime[batteryToConsider] <= currentTime) {
                    // This battery is currently available
                    foundBatteryIndex = batteryToConsider;
                    // We found an available battery, so we can stop searching for now
                    break;
                } else {
                    // This battery is recharging, keep track of when it will be available
                    earliestRechargeCompletionTime = Math.min(earliestRechargeCompletionTime, batteryAvailableTime[batteryToConsider]);
                }
            }

            if (foundBatteryIndex != -1) {
                // We found an available battery!
                int actualCapacity = capacity[foundBatteryIndex];

                // Calculate how much time we can actually use this battery for 't' minutes
                // It's either its full capacity or the remaining 't' time, whichever is smaller.
                int minutesToUse = Math.min(actualCapacity, t);

                t -= minutesToUse; // Decrement remaining phone usage time
                currentTime += minutesToUse; // Advance current simulation time
                batteriesUsedCount++; // Count this battery as used

                // This battery is now depleted and starts recharging.
                // Its availability time will be current time + its recharge duration.
                batteryAvailableTime[foundBatteryIndex] = currentTime + recharge[foundBatteryIndex];

                // Move to the next battery in the cycle for the *next* usage attempt
                currentBatteryPointer = (foundBatteryIndex + 1) % n;

            } else {
                // All batteries are currently recharging. We need to wait.

                // If the earliest a battery will be available is beyond the time 't' we need the phone,
                // then it's impossible to continue.
                if (earliestRechargeCompletionTime - currentTime >= t) {
                    return -1; // Cannot keep the phone working for the entire duration
                }

                // Advance currentTime to the moment the soonest battery becomes available.
                // We don't decrement 't' here because the phone is not being used during this wait.
                long timeToWait = earliestRechargeCompletionTime - currentTime;
                currentTime += timeToWait;

                // The currentBatteryPointer might need to be reset or handled carefully
                // since we just jumped time. We'll let the next iteration of the while loop
                // (which starts by searching from `currentBatteryPointer`) find the now-available battery.
                // No change to currentBatteryPointer needed here as the next iteration will re-evaluate.
            }
        }

        return batteriesUsedCount;
    }


    public static void main(String[] args) {
        int t1 = 16;
        int[] capacity1 = {2, 5, 6};
        int[] recharge1 = {12, 1, 4};
        System.out.println(solution_old(t1, capacity1, recharge1)); // ✅ Expected: 3

        int t2 = 16;
        int[] capacity2 = {2, 5, 6};
        int[] recharge2 = {12, 8, 4};
        System.out.println(solution_old(t2, capacity2, recharge2)); // ✅ Expected: -1
    }
}