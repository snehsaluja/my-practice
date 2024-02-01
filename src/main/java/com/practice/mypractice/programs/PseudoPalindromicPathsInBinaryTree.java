package com.practice.mypractice.programs;

import com.practice.mypractice.programs.dto.TreeNode;

public class PseudoPalindromicPathsInBinaryTree {

    private int counter = 0;
    private int n = 0;
    //private int[] chars = new int[100001];
    private int[] freq = new int[10];

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root != null) {
            //chars[0] = root.val;
            findCount(root);
        }
        return counter;
    }

    private void findCount(TreeNode node) {
        if (node == null) {
            return;
        }
        //chars[n] = node.val;
        freq[node.val]++;
        n++;
        if (node.left == null && node.right == null && isPseudoPalindrome(freq, n)) {
            counter++;
        }
        findCount(node.left);
        findCount(node.right);
        n--;
        freq[node.val]--;
    }

/*

    private void findCount(TreeNode node) {
        if (node == null) {
            return;
        }
        chars[n++] = node.val;

        if (node.left == null && node.right == null && isPseudoPalindrome(chars, n)) {
            counter++;
        }
        findCount(node.left);
        findCount(node.right);
        n--;
    }
*/

    private boolean isPseudoPalindrome(int[] freq, int n) {
        int oddNoCount = 0;
        for (int i = 1; i < 10; i++) {
            if (freq[i] % 2 == 1) {
                oddNoCount++;
            }
        }
        return (oddNoCount <= 1);
    }

    public static void main(String[] args) {

    }

}
