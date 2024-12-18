package com.practice.mypractice.programs.linkedlist;

import com.practice.mypractice.programs.dto.ListNode;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode temp = new ListNode();
        ListNode resultHead = temp;
        while (true) {
            int min = Integer.MAX_VALUE, index = 0;
            boolean found = false;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    index = i;
                    found = true;
                }
            }
            if (!found) {
                break;
            }
            temp.next = new ListNode(min);
            temp = temp.next;
            lists[index] = lists[index].next;
        }
        return resultHead.next;
    }

    public static void main(String[] args) {

    }
}
