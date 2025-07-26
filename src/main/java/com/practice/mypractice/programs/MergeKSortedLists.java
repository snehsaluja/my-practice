package com.practice.mypractice.programs;

import com.practice.mypractice.programs.dto.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resultNode = new ListNode(0);
        ListNode head = resultNode;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.val - o2.val;
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                pq.offer(lists[i]);
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            resultNode.next = new ListNode(node.val);
            resultNode = resultNode.next;
            node = node.next;
            if (node != null) {
                pq.offer(node);
            }
        }

        return head.next;
    }
}
