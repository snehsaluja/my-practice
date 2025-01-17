package com.practice.mypractice.programs;

public class NeighboringBitwiseXOR {

    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] original = new int[n];

        for (int i = 1; i < n; i++) {
            original[i] = derived[i - 1] ^ original[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (derived[i] != (original[i] ^ original[(i + 1) % n]))
                return false;
        }
        return true;
    }

    public boolean doesValidArrayExist_Best(int[] derived) {
        int n = derived.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            result ^= derived[i];
        }
        return result == 0;
    }

    public static void main(String[] args) {

    }
}
