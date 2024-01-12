package com.practice.mypractice.programs.trees;

import com.practice.mypractice.programs.dto.TreeNode;

public class MaxDiffNodeAncestor {

    public static int diff = 0;

    public static int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMaxDiff(root, root.val, root.val);
        return diff;
    }

    private static void getMaxDiff(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }

        diff = Math.max(diff, Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        getMaxDiff(root.left, min, max);
        getMaxDiff(root.right, min, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2, null, new TreeNode(0, new TreeNode(3), null));
        System.out.println(maxAncestorDiff(root));
    }

}
