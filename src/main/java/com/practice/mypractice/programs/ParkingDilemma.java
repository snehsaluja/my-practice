package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Twitter, Booking.com questions

public class ParkingDilemma {

    public static int minRoofSize(List<Integer> pos, int k) {
        int minCount = Integer.MAX_VALUE, n = pos.size();
        Collections.sort(pos);
        for (int i = 0; i + k - 1 < n; i++) {
            minCount = Math.min(minCount, pos.get(i + k - 1) - pos.get(i));
        }
        return minCount + 1;
    }

    public static void main(String[] args) {
        testMinRoofSize(Arrays.asList(2, 9, 15, 17), 2, 3);
        testMinRoofSize(Arrays.asList(2, 10, 8, 17), 3, 9);
        testMinRoofSize(Arrays.asList(18, 12, 31, 14, 4, 26, 22), 3, 7);
        testMinRoofSize(Arrays.asList(80007335, 9987764, 50438796, 32357166, 65477350, 84234476, 15537468, 46875662, 23516720, 38997410, 57843356, 92557746, 73569987, 29476884), 4, 15480691);
        testMinRoofSize(Arrays.asList(86894121, 44997665, 748566, 11022, 3654733, 1975510, 46687319, 97731102), 1, 1);
    }

    private static void testMinRoofSize(List<Integer> list, int k, int expectedAns) {
        System.out.println("Input List = " + list + " ; k = " + k);
        System.out.println("Test Pass = " + (minRoofSize(list, k) == expectedAns));
        System.out.println("------------------------------------------------------");
    }
}
