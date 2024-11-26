package com.practice.mypractice.interview9;
/*

Walmart Round 1:

Given the head of a linked list, remove the nth node from the end of the list and return its head.

        Input: head = [1,2,3,4,5], n = 2
        Output: [1,2,3,5]
        Example 2:

        Input: head = [1], n = 1
        Output: []
        Example 3:

        Input: head = [1,2], n = 1
        Output: [1]
*/


public class Test3 {

    public static void main(String[] args) {

    }

    public ListNode removeNthLastNode(ListNode head, int n) {
        int len = calculateLen(head);
        if (len == n) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
        } else {
            int target = len - n - 1;
            ListNode aux = head;
            while (target > 0) {
                aux = aux.next;
                target--;
            }

            ListNode temp = aux.next;
            aux.next = aux.next.next;
            temp.next = null;
        }
        return head;
    }

    private int calculateLen(ListNode head) {
        return 5;
    }

    public ListNode removeNthLastNodeOptimized(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head), first = dummy, second = dummy;
        dummy.next = head;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        ListNode temp = second.next;
        second.next = second.next.next;
        temp.next = null;
        return dummy.next;
    }

}

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}