package com.practice.mypractice.interview35;

// DREAM 11 - round 1 - Question 1
// https://leetcode.com/problems/reverse-linked-list-ii/description/
public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftNode = head, rightNode, aux1 = dummy, aux2;
        int k = 0;
        while (k < left - 1 && leftNode != null) {
            leftNode = leftNode.next;
            aux1 = aux1.next;
            k++;
        }
        rightNode = leftNode;
        aux2 = rightNode.next;
        while (k < right - 1 && rightNode != null) {
            rightNode = rightNode.next;
            aux2 = aux2.next;
            k++;
        }

        ListNode newHead = reverseRecursively(leftNode, null, rightNode);
        aux1.next = newHead;
        leftNode.next = aux2;
        return dummy.next;
    }

    private ListNode reverseRecursively(ListNode curr, ListNode prev, ListNode target) {
        if (curr == target) {
            curr.next = prev;
            return curr;
        }

        ListNode newHead = reverseRecursively(curr.next, curr, target);
        curr.next = prev;
        return newHead;
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
}
