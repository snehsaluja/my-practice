package com.practice.mypractice.programs.linkedlist;

import com.practice.mypractice.programs.dto.ListNode;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode back = dummy, forward = head;

        while (forward != null) { // back != null

            int groupLen = 0;
            while (forward != null && groupLen < k) {
                forward = forward.next;
                groupLen++;
            }

            if (groupLen != k) {
                break;
            }

            ListNode last = back.next;
            back.next = reverseSubList(back.next, forward);
            last.next = forward;
            back = last;
        }

        return dummy.next;
    }

    public ListNode reverseSubList(ListNode begin, ListNode end) {
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
