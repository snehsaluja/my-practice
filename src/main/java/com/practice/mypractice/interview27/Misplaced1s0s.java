package com.practice.mypractice.interview27;


// Paypal Round 1 (5th Dec):
// Minimum number of swaps required to keep all 1s and 0s together.

/* Example Input = [1,0,1,0,1] ; swap arr[0] with arr[3] => [0,0,1,1,1]
   Example Output = 1 ; only 1 swap required

   Example Input = [1,0,1,1,0,0,1] ; swap arr[1] with arr[6] => [1,1,1,1,0,0,0]
   output = 1

   Example Input = [1,0,0,1,1,0,0,0,1] ; swap arr[1] with arr[8] then swap arr[2] with arr[4] => [1,1,1,1,0,0,0,0,0]
   output = 2
*/

import java.util.List;

public class Misplaced1s0s {

    public static void main(String[] args) {

    }

    public int findMinSwaps(List<Integer> databaseStorage) {
        int ones = 0, zeros = 0;
        for (int i = 0; i < databaseStorage.size(); i++) {
            if (databaseStorage.get(i) == 1) {
                ones++;
            } else {
                zeros++;
            }
        }
        int onesMisplaced = 0, zerosMispalced = 0;
        for (int i = 0; i < ones; i++) {
            if (databaseStorage.get(i) != 1) {
                onesMisplaced++;
            }
        }
        for (int i = 0; i < zeros; i++) {
            if (databaseStorage.get(i) != 0) {
                zerosMispalced++;
            }
        }
        return Math.min(onesMisplaced, zerosMispalced);
    }
}
