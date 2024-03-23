package com.practice.mypractice.programs.linkedlist;

import com.practice.mypractice.programs.dto.ListNode;

public class MergeInBetweenLinkedLists {

    public static void main(String[] args) {

    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int k = 0;
        ListNode aux1 = list1, aux2;
        while (aux1.next != null && k < a - 1) {
            aux1 = aux1.next;
            k++;
        }
        aux2 = aux1;
        while (aux2.next != null && k < b) {
            aux2 = aux2.next;
            k++;
        }
        aux1.next = list2;
        aux1 = list2;
        while (aux1.next != null) {
            aux1 = aux1.next;
        }
        aux1.next = aux2.next;

        return list1;
    }
}
