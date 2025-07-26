package com.practice.mypractice.programs.greedy;

public class DeleteColumnsToMakeSortedII {

    public int minDeletionSize(String[] strs) {
        int count = 0, len = strs[0].length();
        for (int i = 0; i < len; i++) {
            int prev = 0;
            boolean found = true;
            for (int j = 0; j < strs.length; j++) {
                int charInt = strs[j].charAt(i);
                if (prev > charInt) {
                    count++;
                    found = false;
                    break;
                }
                prev = charInt;
            }
            if (found)
                break;
        }
        return count;
    }


}
