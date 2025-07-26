package com.practice.mypractice.programs.trees;

import com.practice.mypractice.programs.dto.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueBinarySearchTreesII_95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        Map<String, List<TreeNode>> memo = new HashMap<>();
        return generateTreesHelper(1, n, memo);
    }

    private List<TreeNode> generateTreesHelper(int start, int end, Map<String, List<TreeNode>> memo) {
        String key = start + "-" + end;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        if (start > end) {
            treeNodes.add(null);
            return treeNodes;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generateTreesHelper(start, i - 1, memo);
            List<TreeNode> rightTree = generateTreesHelper(i + 1, end, memo);
            for (TreeNode leftNode : leftTree) {
                for (TreeNode rightNode : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    treeNodes.add(root);
                }
            }
        }
        memo.put(key, treeNodes);
        return treeNodes;
    }

    public static void main(String[] args) {

    }
}
