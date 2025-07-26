package com.practice.mypractice.interview24;

/*

Agoda Round 1 (3rd Dec) (Lead SW Engineer)

A video game developer is creating a game involving enemy aircraft.
In the game, each plane has a starting position above ground level and a speed at which it is descending.
The player character has a gun that can shoot one aircraft during each second.
The game ends when a plane is allowed to land.
Determine the maximum number of planes that can be prevented from landing.

Example
startHeight = [1, 3, 5, 4, 8]
descentRate = [1, 2, 2, 1, 2]
output = 4

*/

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class AirInvaders {
    public static void main(String[] args) {
        System.out.println(airInvaders(Lists.newArrayList(1, 3, 5, 4, 8),
                Lists.newArrayList(1, 2, 2, 1, 2)));
    }

    public static int airInvaders(List<Integer> startHeight, List<Integer> descentRate) {
        int count = 0, n = startHeight.size();
        int[] time = new int[n];

        for (int i = 0; i < n; i++) {
            time[i] = (int) Math.ceil(startHeight.get(i) / (double) descentRate.get(i));
        }
        System.out.println(Arrays.toString(time));
        Arrays.sort(time);
        for (int i = 0; i < n; i++) {
            if (time[i] > i) {
                count++;
            } else if (time[i] <= i) {
                break;
            }
        }
        return count;
    }
}
