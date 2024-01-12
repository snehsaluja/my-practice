package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.List;

import com.practice.mypractice.programs.dto.TreeNode;

public class LeafSimilarTrees {


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSeq1 = new ArrayList<>();
        List<Integer> leafSeq2 = new ArrayList<>();

        populateLeafSeq(root1, leafSeq1);
        populateLeafSeq(root2, leafSeq2);

        return leafSeq1.equals(leafSeq2);
    }

    private void populateLeafSeq(TreeNode root, List<Integer> leafSeq) {
        if (root != null) {
            if(root.left == null && root.right == null)
                leafSeq.add(root.val);
            else {
                populateLeafSeq(root.left, leafSeq);
                populateLeafSeq(root.right, leafSeq);
            }
        }
    }

    public static void main(String[] args) {

    }
}
