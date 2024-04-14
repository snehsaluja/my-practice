package com.practice.mypractice.programs;

public class KthSymbolInGrammar {

    public static void main(String[] args) {

    }

    public int kthGrammar(int n, int k) {
        return dfs(n, k, 0);
    }

    private int dfs(int n, int k, int rootVal) {
        if (n == 1) {
            return rootVal;
        }
        int totalNodes = (int) Math.pow(2, n - 1);

        if (k > totalNodes / 2) {
            int nextRootVal = rootVal == 0 ? 1 : 0;
            return dfs(n - 1, k - (totalNodes / 2), rootVal);
        } else {
            return dfs(n - 1, k, rootVal);
        }
    }


    public int kthGrammarIterative(int n, int k) {

        int totalElements = 1 << (n - 1); // equivalent to (int) Math.pow(2, n-1);
        boolean isPresentInSecondHalf = false;
        while (totalElements > 1) {
            totalElements /= 2;
            if (k > totalElements) { // i.e. k lies on the second half
                k -= totalElements;
                isPresentInSecondHalf = !isPresentInSecondHalf;
            }
        }

        return isPresentInSecondHalf ? 1 : 0;
    }

}


/*
*
*   0
*   01
*   0110
*   01101001
*   0110100110010110
*
* */