package com.practice.mypractice.programs.linkedlist;

import com.practice.mypractice.programs.dto.ListNode;

public class ReversedLinkedList {

    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode head, ListNode prev) {
        if (head == null)
            return prev;
        ListNode aux = reverseList(head.next, head);
        head.next = prev;
        return aux;
    }

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 4, 5});
    }

    private static void test(int[] nums) {
        ReversedLinkedList obj = new ReversedLinkedList();
        ListNode head = null, aux = null;
        for (int n : nums) {
            if (head == null) {
                head = new ListNode(n);
                aux = head;
            } else {
                aux.next = new ListNode(n);
                aux = aux.next;
            }
        }
        System.out.println(obj.reverseList(head));
    }
}
