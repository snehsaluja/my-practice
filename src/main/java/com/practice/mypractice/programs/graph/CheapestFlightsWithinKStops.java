package com.practice.mypractice.programs.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<Edge> pq = new LinkedList<>();
        int[] result = new int[n];
        Map<Integer, List<Edge>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            result[i] = Integer.MAX_VALUE;
            adjList.put(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], price = flight[2];
            adjList.get(u).add(new Edge(v, price, 0));
        }
        result[src] = 0;
        pq.offer(new Edge(src, 0, -1));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int priceTillNow = e.price;
            int node = e.node;
            int stops = e.stops;
            for (Edge neighbour : adjList.get(node)) {
                int v = neighbour.node;
                int priceTillNeighbour = neighbour.price;
                int p2 = result[v];
                if (priceTillNow + priceTillNeighbour < p2 && stops + 1 <= k) {
                    result[v] = priceTillNow + priceTillNeighbour;
                    pq.offer(new Edge(v, result[v], stops + 1));
                }
            }
        }
        return result[dst] == Integer.MAX_VALUE ? -1 : result[dst];
    }

    class Edge {
        int node;
        int price;
        int stops;

        public Edge(int node, int price, int stops) {
            this.node = node;
            this.price = price;
            this.stops = stops;
        }
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops ob = new CheapestFlightsWithinKStops();
        System.out.println(ob.findCheapestPrice(4,
                new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}},
                0, 3, 1));

        System.out.println(ob.findCheapestPrice(4,
                new int[][]{{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}},
                0, 3, 1));

        System.out.println(ob.findCheapestPrice(5,
                new int[][]{{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}},
                0, 2, 2));

        System.out.println(ob.findCheapestPrice(2,
                new int[][]{{0, 2, 1}},
                1, 0, 0));

    }
}
