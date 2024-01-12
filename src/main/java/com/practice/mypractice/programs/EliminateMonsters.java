package com.practice.mypractice.programs;

import java.util.Arrays;

public class EliminateMonsters {

    public static void main(String[] args) {
        int dist[] = {1, 3, 4}, speed[] = {1, 1, 1};
        EliminateMonsters em = new EliminateMonsters();
        System.out.println(em.eliminateMaximum(dist, speed));
    }

    public int eliminateMaximum(int[] dist, int[] speed) {

        //converting dist array to time array
        for (int i = 0; i < dist.length; i++) {
            dist[i] = (dist[i] / speed[i]) + (dist[i] % speed[i] == 0 ? 0 : 1);
            // or dist[i] = (dist[i] - 1) / speed[i]
        }
        Arrays.sort(dist);
        for (int i = 0; i < dist.length; ++i) {
            if (i >= dist[i])       //  or if (i > dist[i])
                return i;
        }
        return dist.length;
    }


    public int eliminateMaximum2(int[] dist, int[] speed) {
        int count = 0, monsters = dist.length;
        int[] time = new int[monsters];
        for (int i = 0; i < monsters; i++) {
            time[i] = (dist[i] / speed[i]) + (dist[i] % speed[i] == 0 ? 0 : 1);
        }
        Arrays.sort(time);
        for (int i = 0; i < monsters; i++) {
            if (time[i] <= i)
                break;
            count++;
        }
        return count;
    }


/*
    This takes more time::

    public int eliminateMaximum(int[] dist, int[] speed) {
        int count = 0, monsters = dist.length, negativeMonsters = 0;
        outer:
        while (count < monsters) {
            count++;
            negativeMonsters = 0;
            for (int i = 0; i < monsters; i++) {
                dist[i] -= speed[i];
                if (dist[i] <= 0) {
                    negativeMonsters++;
                    speed[i] = 0;
                }
                if (negativeMonsters > count) {
                    break outer;
                }
            }
        }
        return count;
    }*/
}
