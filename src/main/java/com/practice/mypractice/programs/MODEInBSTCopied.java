package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Arrays;

import com.practice.mypractice.programs.dto.TreeNode;

public class MODEInBSTCopied {


    TreeNode pre = null;
    int count;
    int maxCount = 0;
    ArrayList<Integer> resList = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(2);
        TreeNode four = new TreeNode(3);
        TreeNode five = new TreeNode(4);
        TreeNode six = new TreeNode(2);
        one.setRight(two);
        two.setLeft(three);
        two.setRight(four);
        four.setLeft(six);
        four.setRight(five);
        MODEInBSTCopied ob = new MODEInBSTCopied();
        System.out.println(Arrays.toString(ob.findMode(one)));
    }

    public int[] findMode(TreeNode root) {
        recursive(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    void recursive(TreeNode cur) {
        if (cur == null) {
            return;
        }
        recursive(cur.left);

        if (pre == null) {
            count = 1;
        } else if (pre.val == cur.val) {
            count++;
        } else {
            count = 1;
        }

        if (count > maxCount) {
            maxCount = count;
            resList.clear();
            resList.add(cur.val);
        } else if (count == maxCount) {
            resList.add(cur.val);
        }
        pre = cur;

        recursive(cur.right);
    }
}
