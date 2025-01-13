package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumHotels {

    //Hacker Rank

    static int solve(List<Integer> customer, int k) {
        int hotels = 0, n = customer.size(), i = 0;
        Collections.sort(customer);
        while (i < n) {
            hotels++;
            int start = customer.get(i);
            while (i < n && customer.get(i) <= (start + (2 * k))) {
                i++;
            }
        }
        return hotels;
    }

    static int solve2(List<Integer> customer, int k) {
        // after sort, we can calculate distance between neighboring customers
        customer.sort(null);
        int hotels = 1;
        int radius = 2 * k;
        Integer startPos = customer.get(0);
        for (int i = 1; i < customer.size(); i++) {
            if ((customer.get(i) - startPos) > radius) {
                startPos = customer.get(i);
                hotels++;
            }
        }
        return hotels;
    }

    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList(1, 4, 6, 2), 2));
    }

}
