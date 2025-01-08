package com.practice.mypractice.programs.trees;

import com.practice.mypractice.programs.dto.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean allNullFound = false;
        StringBuilder answer = new StringBuilder();
        while (!q.isEmpty() && !allNullFound) {
            allNullFound = true;
            StringBuilder temp = new StringBuilder();
            int size = q.size();
            while (size-- > 0) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    allNullFound = false;
                    temp.append(curr.val);
                    temp.append(",");
                    q.offer(curr.left);
                    q.offer(curr.right);
                } else {
                    temp.append("null");
                    temp.append(",");
                    q.offer(null);
                    q.offer(null);
                }
            }
            if (!allNullFound) {
                answer.append(temp);
            }
        }
        answer.deleteCharAt(answer.length() - 1);
        return answer.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(",");
        List<TreeNode> list = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        list.add(root);
        for (int i = 1; i < arr.length; i++) {
            String s = arr[i];
            int currRoot = (i - 1) / 2;
            TreeNode newNode = null;
            if (!s.equals("null")) {
                newNode = new TreeNode(Integer.parseInt(s));
            }

            if (list.get(currRoot) != null) {
                if (i % 2 == 1) {
                    list.get(currRoot).left = newNode;
                } else {
                    list.get(currRoot).right = newNode;
                }
            }
            list.add(newNode);
        }
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize_spaceOptimized(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        int index = 1;
        while (!q.isEmpty() && index < arr.length) {
            TreeNode curr = q.poll();
            if (curr != null) {
                if (!arr[index].equals("null")) {
                    curr.left = new TreeNode(Integer.parseInt(arr[index]));
                }
                if (index + 1 < arr.length && !arr[index + 1].equals("null")) {
                    curr.right = new TreeNode(Integer.parseInt(arr[index + 1]));
                }
                q.offer(curr.left);
                q.offer(curr.right);
            } else {
                q.offer(null);
                q.offer(null);
            }
            index+=2;
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree ob = new SerializeAndDeserializeBinaryTree();
        TreeNode root = initTree();
        String output = ob.serialize(root);
        System.out.println(output);
        TreeNode copy = ob.deserialize(output);
        TreeNode copy2 = ob.deserialize_spaceOptimized(output);
        System.out.println(copy);
    }

    private static TreeNode initTree() {
        TreeNode root = new TreeNode(1);

        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);

        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(8);

        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(6);

        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        root.left = b;
        root.right = c;
        return root;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));