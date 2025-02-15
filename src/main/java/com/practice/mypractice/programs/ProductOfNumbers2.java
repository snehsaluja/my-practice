package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers2 {

    int[] list;
    int top;

    public ProductOfNumbers2() {
        list = new int[40001];
        top = -1;
    }

    public void add(int num) {
        list[++top] = num;
        //list.add(num);
    }

    public int getProduct(int k) {
        int prod = 1;
        for (int i = top; i >= top - k + 1; i--) {
            prod *= list[i];
        }
        return prod;
    }
}
