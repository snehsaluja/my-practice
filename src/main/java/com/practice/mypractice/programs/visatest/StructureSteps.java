package com.practice.mypractice.programs.visatest;

/*
public class StructureSteps {
    public static void main(String[] args) {
        int[] structures1 = {1, 4, 3, 2};
        int[] structures2 = {5, 7, 9, 4, 11};

        System.out.println(solution(structures1)); // Output: 4
        System.out.println(solution(structures2)); // Output: 9
    }

    public static int solution(int[] structures) {
        return Math.min(getOps(structures, true), getOps(structures, false));
    }

    private static int getOps(int[] structures, boolean ascending) {
        int ops = 0;
        for (int i = 0; i < structures.length; i++) {
            int target = ascending ? structures[0] + i : structures[0] - i;
            int diff = target - structures[i];
            if (diff > 0) {
                ops += diff; // Only add operations allowed
            }
        }
        return ops;
    }
}
*/

/*
public class StructureSteps {

    public static void main(String[] args) {
        int[] structures1 = {1, 4, 3, 2};    // Expected: 4
        int[] structures2 = {5, 7, 9, 4, 11}; // Expected: 9
        System.out.println(solution(structures1));
        System.out.println(solution(structures2));
        int[] structures3 = {2, 1000};
        System.out.println(solution(structures3));
    }

    public static int solution(int[] structures) {
        int n = structures.length;
        int minCost = Integer.MAX_VALUE;

        // Try ascending patterns: base from structures[0] to structures[0] + n
        for (int base = structures[0]; base <= structures[0] + n; base++) {
            int cost = 0;
            boolean valid = true;
            for (int i = 0; i < n; i++) {
                int target = base + i;
                if (target < structures[i]) {
                    valid = false;
                    break;
                }
                cost += target - structures[i];
            }
            if (valid) minCost = Math.min(minCost, cost);
        }

        // Try descending patterns: base from structures[0] to structures[0] + n
        for (int base = structures[0]; base <= structures[0] + n; base++) {
            int cost = 0;
            boolean valid = true;
            for (int i = 0; i < n; i++) {
                int target = base - i;
                if (target < structures[i]) {
                    valid = false;
                    break;
                }
                cost += target - structures[i];
            }
            if (valid) minCost = Math.min(minCost, cost);
        }

        return minCost;
    }
}*/

public class StructureSteps {

    public static void main(String[] args) {
        int[] structures1 = {1, 4, 3, 2};       // Output: 4
        int[] structures2 = {5, 7, 9, 4, 11};   // Output: 9
        int[] structures3 = {2, 1000};          // Output: 997

        System.out.println(solution(structures1));
        System.out.println(solution(structures2));
        System.out.println(solution(structures3));
    }

    public static int solution(int[] structures) {
        int n = structures.length;
        int minCost = Integer.MAX_VALUE;

        // Ascending pattern: try all base values from max(structures[i] - i)
        int baseStartAsc = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            baseStartAsc = Math.max(baseStartAsc, structures[i] - i);
        }

        for (int base = baseStartAsc; base <= baseStartAsc + 1000; base++) {
            int cost = 0;
            for (int i = 0; i < n; i++) {
                int target = base + i;
                if (target < structures[i]) {
                    cost = Integer.MAX_VALUE;
                    break;
                }
                cost += target - structures[i];
            }
            minCost = Math.min(minCost, cost);
        }

        // Descending pattern: try all base values from max(structures[i] + i)
        int baseStartDesc = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            baseStartDesc = Math.max(baseStartDesc, structures[i] + i);
        }

        for (int base = baseStartDesc; base <= baseStartDesc + 1000; base++) {
            int cost = 0;
            for (int i = 0; i < n; i++) {
                int target = base - i;
                if (target < structures[i]) {
                    cost = Integer.MAX_VALUE;
                    break;
                }
                cost += target - structures[i];
            }
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }
}
