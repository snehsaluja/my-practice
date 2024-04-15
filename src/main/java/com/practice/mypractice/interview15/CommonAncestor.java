package com.practice.mypractice.interview15;

public class CommonAncestor {

    public static void main(String[] args) {

        TreeNode root = initTree();

        System.out.println(isSiblingOrCousin(root, 'D', 'E'));
        System.out.println(isSiblingOrCousin(root, 'D', 'F'));
        System.out.println(isSiblingOrCousin(root, 'D', 'G'));
        System.out.println(isSiblingOrCousin(root, 'G', 'E'));
        System.out.println(isSiblingOrCousin(root, 'B', 'E'));
        System.out.println(isSiblingOrCousin(root, 'B', 'C'));
        System.out.println(isSiblingOrCousin(root, 'A', 'A'));
        System.out.println(isSiblingOrCousin(root, 'A', 'F'));
    }


    /*
                     A
                 B        C
             D    E      F   G


    */

    public static boolean isSiblingOrCousin(TreeNode root, char child1, char child2) {
        if (child1 == child2) {       // handling a case where both characters are same.
            return false;
        }
        int levelChild1 = getLevel(root, child1);
        int levelChild2 = getLevel(root, child2);

        return levelChild1 == levelChild2;
    }

    private static int getLevel(TreeNode root, char ch) {
        if (root == null)
            return 0;

        if (root.val == ch) {
            return 1;
        }

        int levelLeft = getLevel(root.left, ch);
        int levelRight = 0;
        if (levelLeft == 0) {
            levelRight = getLevel(root.right, ch);
        }
        return (levelLeft + levelRight) > 0 ? (levelLeft + levelRight + 1) : 0;

    }

    private static TreeNode initTree() {
        TreeNode root = new TreeNode('A');

        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');

        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');

        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');

        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        root.left = b;
        root.right = c;
        return root;
    }
}

class TreeNode {

    public char val;
    public TreeNode left;
    public TreeNode right;

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    TreeNode() {
    }

    public TreeNode(char val) {
        this.val = val;
    }

    public TreeNode(char val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
