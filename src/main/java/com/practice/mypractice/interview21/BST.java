package com.practice.mypractice.interview21;

public class BST {

// Service Now:

//                         100
//                  52                  200
//              2        70         130      250
//            1        60       80
    //               55    61
    //            53   57
//


    public static void main(String[] args) {

    }

    public void deleteNode(TreeNode root, int num) {
        TreeNode curr = root;
        while (curr != null && num != curr.val) {
            if (num < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        TreeNode nextGreater = curr.right, parent = curr;
        //int min = nextGreater.val;
        while (nextGreater != null) {
            if (nextGreater.left != null) {
                //min = nextGreater.val;
                parent = nextGreater;
                nextGreater = nextGreater.left;
            } else {
                break;
            }
        }
        curr.val = nextGreater.val;

        if (nextGreater.right != null) {
            parent.left = nextGreater.right;
        }
    }

}

class TreeNode {

    int val;

    TreeNode right;

    TreeNode left;

}