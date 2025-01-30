package com.practice.mypractice.programs.trees;

import com.practice.mypractice.programs.dto.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumNumberOfOperationsToSortSBinaryTreeByLevel {

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            int[] arr = new int[q.size()];
            int k = 0;
            for (TreeNode n : q) {
                arr[k++] = n.val;
            }

            count += minSwaps(arr, k);
        }
        return count;
    }

    private int minSwaps(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] temp = arr.clone();
        Arrays.sort(temp);

        for (int i = 0; i < arr.length; i++) {
            map.put(temp[i], i);
        }

        int ans = 0;
        for (int i = 0; i < arr.length;) {
            int ind = map.get(arr[i]);
            if (ind == i) {
                i++;
            } else {
                int tmp = arr[i];
                arr[i] = arr[ind];
                arr[ind] = tmp;
                ans++;
            }
        }
        return ans;
    }

    // ************* Ignore below methods ********
    private int minSwapsBAD(int[] arr, int n) {
        int[] temp = Arrays.copyOf(arr, n);
        Arrays.sort(temp);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != temp[i]) {
                ans++;
                int newIndex = search(arr, temp[i]);
                swap(arr, i, newIndex);
            }
        }
        return ans;
    }

    private int search(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                return i;
        }
        return -1;
    }

    private void swap(int[] arr, int i, int newIndex) {
        int temp = arr[i];
        arr[i] = arr[newIndex];
        arr[newIndex] = temp;
    }
    // ************* Ignore above methods ********

    public static void main(String[] args) {

    }
}
