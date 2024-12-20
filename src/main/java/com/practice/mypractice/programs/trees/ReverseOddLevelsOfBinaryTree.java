package com.practice.mypractice.programs.trees;

import com.practice.mypractice.programs.dto.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseOddLevelsOfBinaryTree {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        TreeNode ten = new TreeNode(10);
        TreeNode eleven = new TreeNode(11);
        TreeNode twelve = new TreeNode(12);
        TreeNode thirteen = new TreeNode(13);
        TreeNode fourteen = new TreeNode(14);
        TreeNode fifteen = new TreeNode(15);

        one.setLeft(two);
        one.setRight(three);
        two.setLeft(four);
        two.setRight(five);
        three.setLeft(six);
        three.setRight(seven);

        four.setLeft(eight);
        four.setRight(nine);
        five.setLeft(ten);
        five.setRight(eleven);

        six.setLeft(twelve);
        six.setRight(thirteen);
        seven.setLeft(fourteen);
        seven.setRight(fifteen);
        ReverseOddLevelsOfBinaryTree ob = new ReverseOddLevelsOfBinaryTree();
        ob.reverseOddLevels(one);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null)
            return null;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Stack<Integer> stack = new Stack<>();
        boolean oddLevel = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left != null) { // since its a perfect binary tree
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                }

                if (!oddLevel) {
                    if (curr.left != null) {    // since its a perfect binary tree
                        stack.push(curr.left.val);
                        stack.push(curr.right.val);
                    }
                } else {
                    curr.val = stack.pop();
                }
            }
            oddLevel = !oddLevel;
        }
        return root;
    }

    public TreeNode reverseOddLevelsOptimized(TreeNode root) {
        if (root == null)
            return null;
        reverseDFS(root.left, root.right, 1);
        return root;
    }

    private void reverseDFS(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null) {
            return;
        }
        if (level % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        reverseDFS(left.left, right.right, level + 1);
        reverseDFS(left.right, right.left, level + 1);
    }

}
