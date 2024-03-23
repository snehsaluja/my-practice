package com.practice.mypractice.programs.linkedlist;

import com.practice.mypractice.programs.dto.ListNode;

public class ReversedLinkedList2 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode aux = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return aux;
    }

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 4, 5});
    }

    private static void test(int[] nums) {
        ReversedLinkedList2 obj = new ReversedLinkedList2();
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
