package com.practice.mypractice.programs.linkedlist;

import com.practice.mypractice.programs.dto.ListNode;

public class ReverseNodesInKGroup_Pratice {

    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode back = dummy, forward = back.next;

        while (forward != null) {
            int count = 0;
            while (forward != null && count < k) {
                forward = forward.next;
                count++;
            }
            if (count != k) {
                break;
            }
            ListNode sublistLast = back.next;
            back.next = reverseSubList(back.next, forward);
            sublistLast.next = forward;
            back = sublistLast;
        }
        return dummy.next;
    }

    private ListNode reverseSubList(ListNode begin, ListNode end) {
        ListNode prev = null, next;
        while (begin != end) {
            next = begin.next;
            begin.next = prev;
            prev = begin;
            begin = next;
        }
        return prev;
    }
}
