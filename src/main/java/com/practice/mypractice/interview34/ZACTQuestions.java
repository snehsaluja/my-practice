package com.practice.mypractice.interview34;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// ZACT Interview Round 1

public class ZACTQuestions {

    public static void main(String[] args) {

        //Question 1 :
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> collect = Arrays.stream(arr).filter(k -> k % 2 == 0).map(k -> k / 2).boxed().collect(Collectors.toList());
        System.out.println(collect);

        //Question 2:
        CustomLinkedList ll = new CustomLinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.displayList();
        ll.reverse();
        ll.displayList();
    }

}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class CustomLinkedList {

    Node head;

    CustomLinkedList() {
    }

    public void add(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(val);
    }

    public Node reverse() {
        if (head == null) {
            return null;
        }
        head = reverseRecursively(head, null);
        return head;
    }

    private Node reverseRecursively(Node current, Node prev) {
        if (current.next == null) {
            current.next = prev;
            return current;
        }

        Node newHead = reverseRecursively(current.next, current);
        current.next = prev;
        return newHead;
    }

    public void displayList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "-> \t");
            temp = temp.next;
        }
        System.out.println();
    }

}
