package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.List;

import com.practice.mypractice.programs.dto.TreeNode;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversalList = new ArrayList<>();
        inorderTraversal(root, traversalList);
        return traversalList;
    }

    private void inorderTraversal(TreeNode root, List<Integer> traversalList) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, traversalList);
        traversalList.add(root.val);
        inorderTraversal(root.right, traversalList);
    }

    public static void main(String[] args) {

    }
}
