package com.practice.mypractice.interview13;

/*
Ring Central Interview:

Given a list of strings input and an integer k, return the top k most frequent strings. You may return the answer in any order if the frequency of two strings is the same.

        Example 1:

        Input: input = [ orange, orange, apple, orange, apple, apple, banana ],  k = 2

        Output: [ orange, apple ]
        In case of same freq , output should be lexicographically sorted: Output: [ apple, orange ]

        Example 2:

        Input: input = [ orange ], k = 1

        Output: [ orange ]
*/


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;

public class MostKFrequentStrings {

    public static void main(String[] args) {
        System.out.println(getKMostFrequentStrings(
                Lists.newArrayList("orange", "orange", "orange", "orange", "apple", "apple", "apple", "apple", "banana"), 2));
    }

    public static List<String> getKMostFrequentStrings(List<String> fruits, int k) {
        LinkedList<String> linkedList = new LinkedList<>();

        Map<String, Integer> map = new HashMap<>();

        for (String fruit : fruits) {
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
        }

        PriorityQueue<Fruit> pq = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(Fruit.builder().name(entry.getKey()).freq(entry.getValue()).build());
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (k > 0 && !pq.isEmpty()) {
            linkedList.addFirst(pq.poll().getName());
            k--;
        }

        // Space Complexity = O(n) + O(k) = O(n)
        // Time Complexity = O(n)+O(n)+O(k) = O(3n) = O(n)
        return linkedList;
    }

}

@Data
@Builder
class Fruit implements Comparable<Fruit> {
    public String name;
    public int freq;

    @Override
    public int compareTo(Fruit o1) {
        if (this.getFreq() - o1.getFreq() == 0) {
            return o1.getName().compareTo(this.getName());
        }
        return this.getFreq() - o1.getFreq();
    }
}