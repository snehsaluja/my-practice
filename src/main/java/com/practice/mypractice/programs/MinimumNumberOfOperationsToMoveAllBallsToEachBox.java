package com.practice.mypractice.programs;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        char[] arr = boxes.toCharArray();
        int[] dist = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        int count = arr[0] - '0';

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + count;
            count += arr[i] - '0';
        }
        dist[n - 1] = left[n - 1];
        count = arr[n - 1] - '0';
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + count;
            count += arr[i] - '0';
            dist[i] = left[i] + right[i];
        }
        return dist;
    }

    public int[] minOperations_withoutExtraSpace(String boxes) {
        int n = boxes.length();
        char[] arr = boxes.toCharArray();
        int[] dist = new int[n];

        int count = arr[0] - '0', sum = count;

        for (int i = 1; i < n; i++) {
            dist[i] = sum;
            count += arr[i] - '0';
            sum += count;
        }
        count = arr[n - 1] - '0';
        sum = count;
        for (int i = n - 2; i >= 0; i--) {
            dist[i] = dist[i] + sum;
            count += arr[i] - '0';
            sum += count;
        }
        return dist;
    }

    public static void main(String[] args) {

    }
}
