package com.practice.mypractice.programs.dto;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode convertToList(int[] arr) {
        ListNode head = null, aux = null;
        for (int n : arr) {
            if (head == null) {
                head = new ListNode(n);
                aux = head;
            } else {
                aux.next = new ListNode(n);
                aux = aux.next;
            }
        }
        return head;
    }

    public static void displayList(ListNode head) {
        ListNode aux = head;
        while (aux != null) {
            System.out.print(aux.val + " -> ");
            aux = aux.next;
        }
        System.out.println("<EOL>");
    }
}