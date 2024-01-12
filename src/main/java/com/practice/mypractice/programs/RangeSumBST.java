package com.practice.mypractice.programs;

import com.practice.mypractice.programs.dto.TreeNode;

public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root != null) {
            if (root.val > low && root.val < high) {
                return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
            } else if (root.val < low) {
                return rangeSumBST(root.right, low, high);
            } else if (root.val == low) {
                return root.val + rangeSumBST(root.right, low, high);
            } else if (root.val > high) {
                return rangeSumBST(root.left, low, high);
            } else if (root.val == high) {
                return root.val + rangeSumBST(root.left, low, high);
            }
        }
        return 0;
    }

    public int rangeSumBST_short(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST_short(root.left, low, high) + rangeSumBST_short(root.right, low, high);
        } else if (root.val < low) {
            return rangeSumBST_short(root.right, low, high);
        } else {
            return rangeSumBST_short(root.left, low, high);
        }
    }


    // The below is not for BST, but a clean code for normal binary trees.
    public int rangeSum_BinaryTreeCode(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int currentVal = (root.val >= low && root.val <= high) ? root.val : 0;

        int leftSum = rangeSum_BinaryTreeCode(root.left, low, high);
        int rightSum = rangeSum_BinaryTreeCode(root.right, low, high);

        return currentVal + leftSum + rightSum;
    }

    public static void main(String[] args) {

    }
}
