package com.practice.mypractice.programs.trees;

import com.practice.mypractice.programs.dto.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class BinaryTreeCameras {

    public int minCameraCover(TreeNode root) {
        Set<TreeNode> coveredNodes = new HashSet<>();
        coveredNodes.add(null);
        int[] result = new int[1];
        rec(root, null, coveredNodes, result);
        return result[0];
    }

    private void rec(TreeNode current, TreeNode parent, Set<TreeNode> coveredNodes, int[] result) {
        if (current == null) {
            return;
        }
        rec(current.left, current, coveredNodes, result);
        rec(current.right, current, coveredNodes, result);

        if ((parent == null && !coveredNodes.contains(current))
                || !coveredNodes.contains(current.left) || !coveredNodes.contains(current.right)) {
            result[0]++;
            coveredNodes.add(current);
            coveredNodes.add(parent);
            coveredNodes.add(current.left);
            coveredNodes.add(current.right);
        }
    }

    // ============================================================

    public int minCameraCover2(TreeNode root) {
        int[] result = new int[1];
        int rootStatus = dfs(root, null, result);
        return rootStatus == 0 ? result[0] + 1 : result[0];
    }

    // 2 -> Camera
    // 1 -> Covered by some other cam
    // 0 -> uncovered
    private int dfs(TreeNode curr, Object parent, int[] result) {
        if (curr == null) return 1;
        int leftStatus = dfs(curr.left, curr, result);
        int rightStatus = dfs(curr.right, curr, result);
        if (leftStatus == 0 || rightStatus == 0) {
            result[0]++;
            return 2;
        } else if (leftStatus == 2 || rightStatus == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

    }
}
