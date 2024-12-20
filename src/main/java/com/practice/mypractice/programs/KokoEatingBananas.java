package com.practice.mypractice.programs;

public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas ob = new KokoEatingBananas();
        System.out.println(ob.minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int left = 1, right = max, mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (canEatAllBananas(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canEatAllBananas(int[] piles, int h, int speed) {
        int totalTime = 0;
        for (int pile : piles) {
            int time = pile / speed;
            if (pile % speed != 0)
                time++;
            totalTime += time;
        }
        return (totalTime <= h);
    }
}
