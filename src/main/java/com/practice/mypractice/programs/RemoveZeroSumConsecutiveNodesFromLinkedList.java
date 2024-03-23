package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

import com.practice.mypractice.programs.dto.ListNode;


// 1,2,3,-3,1,2

public class RemoveZeroSumConsecutiveNodesFromLinkedList {

    public ListNode removeZeroSumSublists(ListNode head) {

        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        ListNode aux = head, deleteStartNode = null, deleteEndNode = null;
        while (aux != null) {
            sum += aux.val;
            if (sum == 0) {
                deleteEndNode = aux;
                aux = aux.next;
                head = deleteEndNode.next;
                deleteFromHead(head, deleteEndNode, map);
            } else if (map.containsKey(sum)) {
                deleteStartNode = map.get(sum);
                deleteEndNode = aux;
                aux = aux.next;
                delete(deleteStartNode, deleteEndNode, sum, map);
            } else {
                map.put(sum, aux);
                aux = aux.next;
            }
        }
        return head;
    }

    private void delete(ListNode deleteStartNode, ListNode deleteEndNode, int sum, Map<Integer, ListNode> map) {
        ListNode aux = deleteStartNode.next;
        deleteFromMap(deleteEndNode, sum, map, aux);
        deleteStartNode.next = deleteEndNode.next;
        deleteEndNode.next = null;
    }

    private void deleteFromMap(ListNode deleteEndNode, int sum, Map<Integer, ListNode> map, ListNode aux) {
        if (aux == null) return;
        while (aux != deleteEndNode && aux != null) {
            sum += aux.val;
            map.remove(sum);
            aux = aux.next;
        }
    }

    private void deleteFromHead(ListNode head, ListNode deleteEndNode, Map<Integer, ListNode> map) {
        deleteFromMap(deleteEndNode, 0, map, head);
        deleteEndNode.next = null;

    }


    public ListNode removeZeroSumSublistsOptimized(ListNode head) {
        ListNode dummy = new ListNode(0), current = dummy;
        dummy.next = head;
        int sum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while (current != null) {
            sum += current.val;
            if (map.containsKey(sum)) {
                ListNode temp = map.get(sum).next;
                int tempSum = sum + temp.val;
                while (temp != current) {
                    map.remove(tempSum);
                    temp = temp.next;
                    tempSum += temp.val;
                }
                map.get(sum).next = current.next;
            } else {
                map.put(sum, current);
            }
            current = current.next;
        }
        return dummy.next;
    }

    public ListNode removeZeroSumSublistsThirdWay(ListNode head) {
        ListNode dummy = new ListNode(), curr = dummy;
        dummy.next = head;
        int sum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while (curr != null) {
            sum += curr.val;
            map.put(sum, curr);
            curr = curr.next;
        }
        curr = dummy;
        sum = 0;
        while (curr != null) {
            sum += curr.val;
            curr.next = map.get(sum).next;
            //map.get(sum).next = null;
            curr=curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        test(new int[]{1, 2, 1, -2, 0, 0});
        test(new int[]{1, 2, 1, -2, 0});
        test(new int[]{1, 2, 3, -3, -2});
        test(new int[]{1, 2, -3, 3, 1});

    }

    private static void test(int[] ints) {
        ListNode head = ListNode.convertToList(ints);
        RemoveZeroSumConsecutiveNodesFromLinkedList obj = new RemoveZeroSumConsecutiveNodesFromLinkedList();
        head = obj.removeZeroSumSublists(head);
        ListNode.displayList(head);
    }


}
