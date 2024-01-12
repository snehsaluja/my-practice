package com.practice.mypractice.programs;

import com.practice.mypractice.programs.dto.TreeNode;

public class CountNodesEqualToAvgOfSubtree {

    int count = 0;

    public static void main(String[] args) {

    }

    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getAvgOfSubtree(root);

        return count;
    }

    public Avg getAvgOfSubtree(TreeNode root) {
        if (root == null) {
            return new Avg(0, 0);
        }
        Avg leftAvg = getAvgOfSubtree(root.left);
        Avg rightAvg = getAvgOfSubtree(root.right);

        int avg = (leftAvg.sum + root.val + rightAvg.sum) / (leftAvg.n + rightAvg.n + 1);
        if (avg == root.val)
            count++;
        return new Avg(leftAvg.sum + root.val + rightAvg.sum, leftAvg.n + rightAvg.n + 1);

    }

    public class Avg {
        int sum;
        int n;

        Avg(int sum, int n) {
            this.sum = sum;
            this.n = n;
        }
    }
}
