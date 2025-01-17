package com.practice.mypractice.programs.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class KHighestRankedItemsWithinAPriceRange {

    class Hotel {
        int x;
        int y;
        int distance;
        int price;

        public Hotel(int x, int y, int distance, int price) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.price = price;
        }
    }

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Comparator<Hotel> c = getHotelComparator();
        PriorityQueue<Hotel> pq = new PriorityQueue<>(c);
        Queue<Hotel> q = new LinkedList<>();                // size of int = 3
        q.offer(new Hotel(start[0], start[1], 0, grid[start[0]][start[1]]));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Hotel curr = q.poll();
                int x = curr.x, y = curr.y, dist = curr.distance, price = curr.price;
                if (/*grid[x][y] > 1 && */ price >= pricing[0] && price <= pricing[1]) {
                    pq.offer(curr);
                }
                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (isValidCoord(nx, ny, grid, visited)) {
                        visited[nx][ny] = true;
                        q.offer(new Hotel(nx, ny, dist + 1, grid[nx][ny]));
                    }
                }
            }
        }
        return getTopK(k, pq);
    }

    // This was faster in Leetcode as compared to PriorityQueue approach.
    public List<List<Integer>> highestRankedKItems2(int[][] grid, int[] pricing, int[] start, int k) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Comparator<Hotel> c = getHotelComparator();
        List<Hotel> result = new ArrayList<>();
        Queue<Hotel> q = new LinkedList<>();                // size of int = 3
        q.offer(new Hotel(start[0], start[1], 0, grid[start[0]][start[1]]));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Hotel curr = q.poll();
                int x = curr.x, y = curr.y, dist = curr.distance, price = curr.price;
                if (/*grid[x][y] > 1 && */ price >= pricing[0] && price <= pricing[1]) {
                    result.add(curr);
                }
                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (isValidCoord(nx, ny, grid, visited)) {
                        visited[nx][ny] = true;
                        q.offer(new Hotel(nx, ny, dist + 1, grid[nx][ny]));
                    }
                }
            }
        }
        result.sort(c);
        return result.stream().map(hotel -> Arrays.asList(hotel.x, hotel.y)).limit(k).collect(Collectors.toList());
    }

    private static Comparator<Hotel> getHotelComparator() {
        Comparator<Hotel> c = (o1, o2) -> {
            if (o1.distance == o2.distance) {
                if (o1.price == o2.price) {
                    if (o1.x == o2.x) {
                        return o1.y - o2.y;
                    }
                    return o1.x - o2.x;
                }
                return o1.price - o2.price;
            }
            return o1.distance - o2.distance;
        };
        return c;
    }

    private static List<List<Integer>> getTopK(int k, PriorityQueue<Hotel> pq) {
        List<List<Integer>> result = new ArrayList<>();
        while (!pq.isEmpty() && k-- > 0) {
            Hotel h = pq.poll();
            result.add(Arrays.asList(h.x, h.y));
        }
        return result;
    }

    private boolean isValidCoord(int nx, int ny, int[][] grid, boolean[][] visited) {
        return (nx >= 0 && nx < visited.length && ny >= 0 && ny < visited[0].length
                && grid[nx][ny] != 0 && !visited[nx][ny]);
    }

    public static void main(String[] args) {
        KHighestRankedItemsWithinAPriceRange ob = new KHighestRankedItemsWithinAPriceRange();
        System.out.println(ob.highestRankedKItems(new int[][]{{1, 2, 0, 1}, {1, 3, 0, 1}, {0, 2, 5, 1}}, new int[]{2, 5}, new int[]{0, 0}, 3));
    }
}
