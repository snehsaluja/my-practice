package com.practice.mypractice.programs;

public class CollectGarbage {

    public static void main(String[] args) {
        String[] garbage = {"G", "P", "GP", "GG"};
        int[] travel = {2, 4, 3};

        CollectGarbage collectGarbage = new CollectGarbage();
        System.out.println("Time = " + collectGarbage.garbageCollection(garbage, travel));
        System.out.println("Optimized Time = " + collectGarbage.garbageCollectionOptimized(garbage, travel));

        String[] garbage2 = {"MMM","PGM","GP"};
        int[] travel2 = {3,10};
        System.out.println("Time = " + collectGarbage.garbageCollection(garbage2, travel2));
        System.out.println("Optimized Time = " + collectGarbage.garbageCollectionOptimized(garbage2, travel2));

    }

    public int garbageCollection(String[] garbage, int[] travel) {

        int timeCount = 0, pendingG = 0, pendingM = 0, pendingP = 0;
        for (int i = 0; i < garbage.length; i++) {
            String house = garbage[i];
            Garbage g = getGarbageCount(house);
            timeCount += house.length();
            if (i > 0) {
                if (g.metal > 0) {
                    timeCount += pendingM + travel[i - 1];
                    pendingM = 0;
                } else {
                    pendingM += travel[i - 1];
                }

                if (g.paper > 0) {
                    timeCount += pendingP + travel[i - 1];
                    pendingP = 0;
                } else {
                    pendingP += travel[i - 1];
                }

                if (g.glass > 0) {
                    timeCount += pendingG + travel[i - 1];
                    pendingG = 0;
                } else {
                    pendingG += travel[i - 1];
                }
            }
        }
        return timeCount;
    }

    private Garbage getGarbageCount(String house) {
        Garbage g = new Garbage();
        for (int i = 0; i < house.length(); i++) {
            if (house.charAt(i) == 'G') {
                g.glass++;
            } else if (house.charAt(i) == 'P') {
                g.paper++;
            } else if (house.charAt(i) == 'M') {
                g.metal++;
            }
        }
        return g;
    }

    class Garbage {
        int glass;
        int paper;
        int metal;
    }


    // OPTIMIZED SOLUTION:

    boolean hasG = false, hasP = false, hasM = false;

    public int garbageCollectionOptimized(String[] garbage, int[] travel) {
        int n = garbage.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans += 3 * travel[i];
        }
        for (String s : garbage) {
            ans += s.length();
        }
        for (int i = n - 1; i > 0; i--) {
            if (!garbage[i].contains("G")) {
                ans -= travel[i - 1];
            } else {
                break;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (!garbage[i].contains("P")) {
                ans -= travel[i - 1];
            } else {
                break;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (!garbage[i].contains("M")) {
                ans -= travel[i - 1];
            } else {
                break;
            }
        }
        return ans;
    }
}
