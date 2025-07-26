package com.practice.mypractice.programs.linkedlist;

import com.practice.mypractice.programs.dto.ListNode;

public class ConvertBinaryNumberInALinkedListToInteger {

    public static int getDecimalValue(ListNode head) {
        int num = 0;
        ListNode aux = head;
        while (aux != null) {
            num = (num * 2) + (aux.val * 2);
            aux = aux.next;
        }
        return num / 2;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.convertToList(new int[]{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0});
        ListNode head2 = ListNode.convertToList(new int[]{1, 0, 1});
        ListNode head3 = ListNode.convertToList(new int[]{0});
        System.out.println(getDecimalValue(head));
        System.out.println(getDecimalValue(head2));
        System.out.println(getDecimalValue(head3));
    }
}
