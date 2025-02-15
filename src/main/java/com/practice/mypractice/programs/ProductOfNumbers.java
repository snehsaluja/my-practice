package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {

    List<Integer> list;
    int prod = 1;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0) {
            prod = 1;
            list = new ArrayList<>();
        } else {
            prod *= num;
            list.add(prod);
        }
    }

    public int getProduct(int k) {
        int size = list.size();
        if (k > size)
            return 0;
        if (size==k){
            return prod;
        }
        int prev = list.get(size - k-1);
        int ans = prod / prev;
        return ans;
    }
}
