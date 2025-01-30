package com.practice.mypractice.interview25;

import java.util.*;
import java.io.*;

public class GrouponQ2 {

    public static String ArrayChallenge(String[] strArr) {
        // code goes here
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (String pair : strArr) {
            String[] p = pair.replaceAll("[()]", "").split(",");
            int child = Integer.parseInt(p[0]);
            int parent = Integer.parseInt(p[1]);
            adjList.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
            if (adjList.get(parent).size() > 2) {
                return "false";
            }
        }
        return "true";
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        //System.out.print(ArrayChallenge(s.nextLine()));
    }


}
