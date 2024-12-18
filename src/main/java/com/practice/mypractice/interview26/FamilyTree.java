package com.practice.mypractice.interview26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/*
 *  ServiceNow System Design Round:
 *
 *
 *              A
 *          /       \
 *       B             C
 *    /  |  \           \
 *   D   E   F           G
 *      /
 *     H
 *
 *
 * Write the APIs for a FamilyTree:
 *
 * 1. To build a Tree.
 * 2. Check if a member exists in the Family Tree
 * 3. Get All Siblings and Cousin of a given member. Example Input = 'E', Output = {D,F,G}
 *
 *
 * APIs Discussion :
 * 1. To build a Tree.
 *       boolean buildTree(char parent, char child)
 *       boolean buildTree(char[][] pairs)       => [{A,B},{A,C},{B,D},{B,E}....]
 * 2. Check if a member exists in the Family Tree
 *       boolean existsInFamily(char member)
 * 3. Get All Siblings and Cousin of a given member. Example Input = 'E', Output = {D,F,G}
 *       List<Character> getSiblingsAndCousins(char member)
 *
 *
 * */


public class FamilyTree {
    private final Map<Character, List<Character>> parentChildrenMap;
    private final char rootNode;

    FamilyTree(char rootNode) {
        parentChildrenMap = new HashMap<>();
        parentChildrenMap.put(rootNode, new ArrayList<>());
        this.rootNode = rootNode;
    }

    public boolean buildTree(char parent, char child) {
        if (parentChildrenMap.containsKey(parent)) {
            parentChildrenMap.get(parent).add(child);
            parentChildrenMap.put(child, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean existsInFamily(char member) {
        return parentChildrenMap.containsKey(member);
    }

    public List<Character> getSiblingsAndCousins(char member) {
        if (!parentChildrenMap.containsKey(member)) {
            return new ArrayList<>();
        }

        Queue<Character> queue = new LinkedList<>();
        queue.add(rootNode);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean memberFound = false;
            List<Character> siblingsAndCousins = new ArrayList<>();
            while (size-- > 0) {
                char currentMember = queue.poll();
                if (currentMember == member) {
                    memberFound = true;
                } else {
                    siblingsAndCousins.add(currentMember);
                }
                for (char child : parentChildrenMap.get(currentMember)) {
                    queue.offer(child);
                }
            }
            if (memberFound) {
                return siblingsAndCousins;
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree('a');

        familyTree.buildTree('a', 'b');
        familyTree.buildTree('a', 'c');

        familyTree.buildTree('b', 'd');
        familyTree.buildTree('b', 'e');
        familyTree.buildTree('b', 'f');

        familyTree.buildTree('c', 'g');

        familyTree.buildTree('e', 'h');

        System.out.println(familyTree.existsInFamily('h'));
        System.out.println(familyTree.existsInFamily('z'));
        System.out.println(familyTree.existsInFamily('a'));

        List<Character> sibsAndCousins = familyTree.getSiblingsAndCousins('e');
        System.out.println("Siblings and cousins of 'e' => " + sibsAndCousins);

        System.out.println("Siblings and cousins of 'z' => " + familyTree.getSiblingsAndCousins('z'));
    }
}

// Input = E
// queue.offer (A) =>
// A ; size = 1;
// q -> В,С
// size = 2
// B
// siblingsAndCousins =[B]