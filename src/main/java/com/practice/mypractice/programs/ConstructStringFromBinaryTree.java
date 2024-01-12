package com.practice.mypractice.programs;

import com.practice.mypractice.programs.dto.TreeNode;

public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode root) {
        String leftSub = tree2string(root.left);
        String rightSub = tree2string(root.right);
        //rightSub = (rightSub.equals("")) ? "" : rightSub;
        leftSub = doMagic(leftSub, rightSub);
        return root.val + leftSub + rightSub;
    }

    private String doMagic(String leftSub, String rightSub) {
        if (rightSub.equals("")) {
            leftSub = (leftSub.equals("")) ? "" : leftSub;
        } else {
            leftSub = (leftSub.equals("")) ? "()" : leftSub;
        }
        return leftSub;
    }

    private String tree2string(TreeNode root) {
        String s = "";
        if (root != null) {
            String leftSub = tree2string(root.left);
            String rightSub = tree2string(root.right);
            //rightSub = (rightSub.equals("")) ? "" : rightSub;
            leftSub = doMagic(leftSub, rightSub);
            s = s + "(" + root.val;
            s = s + leftSub + rightSub;
            s = s + ")";
            return s;
        }
        return "";
    }

    public static void main(String[] args) {

    }
}
