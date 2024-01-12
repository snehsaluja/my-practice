package com.practice.mypractice.interview;

public class BinaryTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        root.setLeft(two);
        root.setRight(three);
        two.setLeft(four);
        two.setRight(five);
        three.setLeft(six);
        three.setRight(seven);

        BinaryTree bt = new BinaryTree();
        System.out.print(root.value + " ");
        bt.printInOrderTree(root);

        bt.mirrorTree(root);
        System.out.println();
        System.out.print(root.value + " ");
        bt.printInOrderTree(root);
    }

    private void mirrorTree(Node root) {
        if (root == null) {
            return;
        }

        Node temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

        mirrorTree(root.getLeft());
        mirrorTree(root.getRight());
    }

    public void printInOrderTree(Node root) {
        if (root == null) {
            return;
        }

        if (root.getLeft() != null)
            System.out.print(root.getLeft().value + " ");
        if (root.getRight() != null)
            System.out.print(root.getRight().value + " ");

        printInOrderTree(root.getLeft());
        printInOrderTree(root.getRight());

    }
}
