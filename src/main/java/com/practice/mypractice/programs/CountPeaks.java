package com.practice.mypractice.programs;

import java.util.List;

public class CountPeaks {

    public static int countPeaks(List<Integer> values) {
        int count = 0;
        for (int i = 1; i < values.size() - 1; i++) {
            double curr = values.get(i), next = values.get(i + 1), prev = values.get(i - 1);
            if ((curr - next >= 5 && curr - prev >= 5) || (curr - next <= -5 && curr - prev <= -5)) {
                count++;
            }
        }
        return count;
    }
}
