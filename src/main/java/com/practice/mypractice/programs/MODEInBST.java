package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.practice.mypractice.programs.dto.TreeNode;

public class MODEInBST {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(2);
        TreeNode four = new TreeNode(3);
        TreeNode five = new TreeNode(4);
        TreeNode six = new TreeNode(2);
        one.setRight(two);
        two.setLeft(three);
        two.setRight(four);
        four.setLeft(six);
        four.setRight(five);
        MODEInBST ob = new MODEInBST();
        System.out.println(Arrays.toString(ob.findMode(one)));
    }

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        findModeRecursive(root, map);
        return findModeArrayFromMap(map);
    }

    private void findModeRecursive(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.put(root.getVal(), map.getOrDefault(root.getVal(), 0) + 1);
        findModeRecursive(root.getLeft(), map);
        findModeRecursive(root.getRight(), map);

    }

    private int[] findModeArrayFromMap(Map<Integer, Integer> map) {
        AtomicInteger max = new AtomicInteger();
        List<Integer> list = new ArrayList<>();
        map.forEach((num, frequency) -> {
            if (frequency == max.get()) {
                list.add(num);
            }
            if (frequency > max.get()) {
                max.set(frequency);
                list.clear();
                list.add(num);
            }
        });
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
