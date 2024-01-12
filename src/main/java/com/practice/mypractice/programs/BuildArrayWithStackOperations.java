package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.List;

public class BuildArrayWithStackOperations {
    public static void main(String[] args) {
        int[] target = {1, 3};
        int n = 3;
        BuildArrayWithStackOperations ob = new BuildArrayWithStackOperations();
        System.out.println(ob.buildArray(target, n));
    }

    public List<String> buildArray(int[] target, int n) {
        int j = 0;
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n && j < target.length; i++) {
            if (target[j] == i) {
                list.add("Push");
                j++;
            } else {
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }
}
