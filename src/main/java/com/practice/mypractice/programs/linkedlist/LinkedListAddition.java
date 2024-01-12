package com.practice.mypractice.programs.linkedlist;

import com.practice.mypractice.programs.dto.ListNode;

public class LinkedListAddition {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addLists(l1, l2);
    }

    private static ListNode addLists(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode resultHead = null;
        ListNode lastNode = null;
        while (l1 != null || l2 != null) {
            int num1 = (l1 == null) ? 0 : l1.val;
            int num2 = (l2 == null) ? 0 : l2.val;
            ListNode temp = new ListNode((num1 + num2 + carry) % 10);
            carry = (num1 + num2 + carry) / 10;
            if (resultHead == null) {
                resultHead = temp;
                lastNode = resultHead;
            } else {
                lastNode.next = temp;
                lastNode = lastNode.next;
            }
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        if (carry > 0) {
            lastNode.next = new ListNode(carry);
        }
        return resultHead;
    }

    public static void main(String[] args) {

    }
}
