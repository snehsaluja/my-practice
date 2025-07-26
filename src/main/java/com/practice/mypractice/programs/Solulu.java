package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Solulu {

    public static int[] solulu(int[] arr, int[] l, int[] r) {

        int n = arr.length, m = l.length, k = 0;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int li = l[i];
            int ri = r[i];
            int diff = ri - li;

            li = (li - 1) % n;
            ri = li + diff;
            int sum = 0;
            for (int j = li; j <= ri; j++) {
                sum += (arr[j % n]) % 1000000007;
            }
            result[k++] = sum;
        }

        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Arrays.toString(solulu(new int[]{4, 1, 5}, new int[]{1, 3}, new int[]{4, 7})));

        // Testing:

        BlockingQueue<Integer> q = new LinkedBlockingQueue<>();

        Arrays.asList(3,2,1).forEach(d -> {
            new Thread(() -> {
                try {
                    Thread.sleep(d*1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                q.add(d);
            }).start();
        });

        System.out.println(q.take());
    }
    


}
