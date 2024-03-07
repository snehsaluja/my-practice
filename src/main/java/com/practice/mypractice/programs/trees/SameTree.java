package com.practice.mypractice.programs.trees;

import com.practice.mypractice.programs.dto.TreeNode;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return p == null && q == null;
        }
    }

    public static void main(String[] args) {

    }
}
