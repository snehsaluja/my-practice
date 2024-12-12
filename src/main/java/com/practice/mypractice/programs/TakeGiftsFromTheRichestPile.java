package com.practice.mypractice.programs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TakeGiftsFromTheRichestPile {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0;

        for (int gift : gifts) {
            pq.offer(gift);
        }
        for (int i = 0; i < k; i++) {
            pq.offer((int) Math.sqrt(pq.poll()));
        }
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
