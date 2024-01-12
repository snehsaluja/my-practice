package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

import com.practice.mypractice.programs.dto.ListNode;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // xxxxxx WRONG !!!!

        Map<Integer, ListNode> map = new HashMap<>();
        ListNode head = null;

        for (int i = 0; i < numCourses; i++) {
            ListNode temp = new ListNode(i);
            map.put(i, temp);
            if (head == null) {
                head = temp;
            } else {
                head.next = temp;
            }
        }

        for (int[] arr : prerequisites) {
            int a = arr[0], b = arr[1];
            ListNode node1 = map.get(a);
            ListNode node2 = map.get(b);
            node1.next = node2;
        }

        ListNode slow = head, fast = head;
        while (slow.next != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
