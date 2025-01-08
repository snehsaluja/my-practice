package com.practice.mypractice.programs.trees;

import com.practice.mypractice.programs.dto.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return getLen(root) != -1;
    }

    private int getLen(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getLen(root.left);
        int right = getLen(root.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

    }
}
