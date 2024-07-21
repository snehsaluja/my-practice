package com.practice.mypractice;

public class RemoveColouredPieces {

    public static void main(String[] args) {

    }

    public boolean winnerOfGame(String colors) {
        int aCount = 0, bCount = 0;
        char[] charArr = colors.toCharArray();
        for (int i = 0; i < charArr.length - 2; i++) {
            if (charArr[i] == 'A' && charArr[i + 1] == 'A' && charArr[i + 2] == 'A') {
                aCount++;
            } else if (charArr[i] == 'B' && charArr[i + 1] == 'B' && charArr[i + 2] == 'B') {
                bCount++;
            }
        }
        if (aCount > bCount) {
            return true;
        }
        return false;
    }

}
