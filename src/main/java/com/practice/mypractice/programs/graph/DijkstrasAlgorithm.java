package com.practice.mypractice.programs.graph;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class DijkstrasAlgorithm {

    public static void main(String[] args) {

        iPair pair = new iPair(1, 9);
        ArrayList<ArrayList<iPair>> adjList =
                Lists.newArrayList(Lists.newArrayList(pair), Lists.newArrayList(new iPair(0, 9)));
        DijkstrasAlgorithm ob = new DijkstrasAlgorithm();
        System.out.println(ob.dijkstra(adjList, 0));
    }

    /* Adj List will be like =>
    List<List<int[]>> adjList:

    0 -> {1,5} , {2,10}          // this represents there is an edge between 0 and 1 with weight 5
                                 // and edge between 0 and 2 with weight 10
    1 -> {3,3} , {2,1}
    .
    .
    .
    */

    public int[] dijkstraAlgo(List<List<int[]>> adjList, int n, int s) {
        int[] distance = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);   // min-heap of min-distance

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s] = 0;
        pq.offer(new int[]{0, s});      // {distance, node}
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int node = arr[1], dist = arr[0];
            List<int[]> neighbors = adjList.get(node);
            for (int[] neighbor : neighbors) {
                int neighborNode = neighbor[0];
                int neighborDist = neighbor[1];

                if (distance[neighborNode] > (neighborDist + dist)) {
                    distance[neighborNode] = neighborDist + dist;
                    pq.offer(new int[]{distance[neighborNode], neighborNode});
                }
            }
        }

        return distance;
    }


    // GFG:
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int s) {
        int n = adj.size();
        int[] distance = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);   // min-heap of min-distance

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s] = 0;
        pq.offer(new int[]{0, s});      // {distance, node}
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int node = arr[1], dist = arr[0];

            ArrayList<iPair> neighbors = adj.get(node);
            for (iPair neighbor : neighbors) {
                int neighborNode = neighbor.first;
                int neighborDist = neighbor.second;

                if (distance[neighborNode] > (neighborDist + dist)) {
                    distance[neighborNode] = neighborDist + dist;
                    pq.offer(new int[]{distance[neighborNode], neighborNode});
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < distance.length; i++) {
            result.add(distance[i]);
        }
        return result;
    }

}

class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
