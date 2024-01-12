package com.practice.mypractice.interview;

public class Node {

    int value;
    Node right, left;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    public void setRight(Node n){
        this.right = n;
    }

    public void setLeft(Node n){
        this.left = n;
    }

    public Node getRight(){
        return right;
    }

    public Node getLeft(){
        return left;
    }
}
