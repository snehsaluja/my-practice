package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean[] recStack = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (isCycleFoundDFS(adjList, i, recStack, visited))
                return false;
        }

        return true;
    }

    private boolean isCycleFoundDFS(List<List<Integer>> adjList, int start, boolean[] recStack, boolean[] visited) {
        recStack[start] = true;
        visited[start] = true;

        for (int num : adjList.get(start)) {
            if (recStack[num]) {
                return true;
            }
            if (!visited[num]) {
                if (isCycleFoundDFS(adjList, num, recStack, visited)) {
                    return true;
                }
            }
        }

        recStack[start] = false;
        return false;
    }

    public boolean canFinish3(int numCourses, int[][] prerequisites) {
        int[] eachPrereqCount = new int[numCourses];
        for (int[] p : prerequisites) {
            eachPrereqCount[p[1]]++;
        }
        int len = prerequisites.length;
        boolean[] finished = new boolean[len];
        boolean run = true;
        while (run) {
            run = false;
            for (int i = 0; i < len; i++) {
                if (!finished[i] && eachPrereqCount[prerequisites[i][0]] == 0) {
                    finished[i] = true;
                    eachPrereqCount[prerequisites[i][1]]--;
                    run = true;
                }
            }
        }
        for (int i = 0; i < eachPrereqCount.length; i++) {
            if (eachPrereqCount[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
