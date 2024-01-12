package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class DiagonalArrayTraverse {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        List<Integer> resultList = new ArrayList<>();
        int x = nums.size(), y = 0, sum;
        for (List<Integer> yInts : nums) {
            if (yInts.size() > y)
                y = yInts.size();
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                List<Integer> innerList = nums.get(i - j);
                if (j < innerList.size())
                    resultList.add(innerList.get(j));
            }
        }

        for (int j = y - 1; j >= 0; j--) {
            for (int i = 0; i < y; i++) {
                List<Integer> innerList;
                if (x - i - 1 >= 0) {
                    innerList = nums.get(x - i - 1);
                } else {
                    break;
                }
                if (x - j + i < innerList.size())
                    resultList.add(innerList.get(y - j + i));
            }
        }
        return resultList.stream().mapToInt(value -> value).toArray();
    }


    public int[] findDiagonalOrderOptimized(List<List<Integer>> nums) {
        int n = 0;
        List<List<Integer>> sums = new ArrayList<>();
        for (int i = 0; i < nums.size(); ++i) {
            List<Integer> l = nums.get(i);
            int size = l.size();
            n += size;
            for (int j = 0; j < size; ++j) {
                int sum = i + j;
                if (sums.size() == sum)
                    sums.add(new ArrayList<>());
                sums.get(sum).add(l.get(j));
            }
        }
        int[] res = new int[n];
        int k = -1;
        for (List<Integer> l : sums) {
            for (int j = l.size() - 1; j >= 0; --j) {
                res[++k] = l.get(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DiagonalArrayTraverse ob = new DiagonalArrayTraverse();
        int[] diagonalOrder = ob.findDiagonalOrder(newArrayList(newArrayList(1, 2, 3, 4, 5), newArrayList(6, 7),
                newArrayList(8), newArrayList(9, 10, 11), newArrayList(12, 13, 14, 15, 16)));
        System.out.println(Arrays.toString(diagonalOrder));

        diagonalOrder = ob.findDiagonalOrder(newArrayList(newArrayList(1, 2, 3), newArrayList(4),
                newArrayList(5, 6, 7), newArrayList(8), newArrayList(9, 10, 11)));
        System.out.println(Arrays.toString(diagonalOrder));

    }
}
