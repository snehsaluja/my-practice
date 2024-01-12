package com.practice.mypractice.programs;

public class RemoveAdjacentAlmostEqualCharacters {
    public int removeAlmostEqualCharacters(String word) {
        int count = 0, len = word.length();
        boolean[] changed = new boolean[len];

        for (int i = 0; i < len - 1; i++) {
            if (changed[i]) {
                continue;
            }
            int diff = word.charAt(i) - word.charAt(i + 1);
            if (diff <= 1 && diff >= -1) {
                changed[i + 1] = true;
                count++;
            }
        }

        return count;
    }
}
