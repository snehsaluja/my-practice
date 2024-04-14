package com.practice.mypractice.programs.microsonlinetest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*For a graph of N vertices and M edges, assign distinct values from the range [1..N]
to the vertices so that the total sum of values at all of the edges' endpoints is maximal.*/

/*

You are given an undirected graph consisting of N vertices, numbered from 1 to N, and M edges.
The graph is described by two arrays, A and B, both of length
M. A pair (A[K], B[KI), for K from 0 to M-1, describes an edge between vertex A[k] and vertex B[K].
Your task is to assign all values from the range [1..N] to the vertices of the graph, giving one
number to each of the vertices. Do it in such a way that the sum over all edges of the values at the edges endpoints is maximal.
For example, given N = 5, A = (2, 2, 1, 2], B = [1, 3, 4, 41, the graph has four edges:
(2, 1). (2, 3). (1, 4), (2, 4). In order to obtain the maximum sum of weights,
you can assign the following values to the vertices: 3, 5, 2, 4, 1 (to vertices 1, 2, 3, 4, 5 respectively).


*/



public class GraphTest {

    class Vertex {
        int id;
        int value;

        Vertex(int id, int value) {
            this.id = id;
            this.value = value;
        }
    }

    public int solution(int N, int[] A, int[] B) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
        }

        System.out.println(map);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));

        int num = 1, sum = 0;
        for (int i = 1; i < N - list.size(); i++) {
            //sum += (num);
            num++;
        }
        for (Map.Entry<Integer, Integer> entry : list) {
            int count = entry.getValue();
            sum += (num * count);
            System.out.println((num * count));
            num++;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
