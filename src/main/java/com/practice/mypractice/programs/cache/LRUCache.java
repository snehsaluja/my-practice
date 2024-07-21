package com.practice.mypractice.programs.cache;

import java.util.HashMap;
import java.util.Map;

/*
Requirements:
1. Get
2. Put
3. Update in Put if Key already exists
4. Display
*/

public class LRUCache<K, V> implements Cache<K, V> {

    // 1,2,3,4,5

    private static final int CAPACITY = 5;

    Map<K, Node<K, V>> cacheMap = new HashMap<>();

    Node<K, V> head, tail;

    @Override
    public void put(K key, V value) {

        // Add Logic:
        Node<K, V> node;
        if (cacheMap.containsKey(key)) {
            node = cacheMap.get(key);
            node.value = value;
            // Now move that node to the head of the list (front):
            moveNodeToHead(node);
        } else { // It is a new Key-Value Pair
            // Now check the capacity only if it is full
            evictLeastRecentlyUsed();
            // Create A Node first:
            node = new Node<>(key, value);
            // Add that node to CacheMap:
            cacheMap.put(key, node);
            // Now add that node to the head of the list (front):
            addToHead(node);
        }


    }

    private void evictLeastRecentlyUsed() {
        if (cacheMap.size() == CAPACITY) {
            // Remove Logic
            K removableKey = tail.key;
            // Remove from List:
            tail = tail.prev;
            tail.next = null;
            // Remove from cacheMap:
            cacheMap.remove(removableKey);
        }
    }

    @Override
    public V get(K key) {
        V value = null;
        if (cacheMap.containsKey(key)) {
            Node<K, V> node = cacheMap.get(key);
            value = node.value;
            // Re-arrange Logic
            moveNodeToHead(node);
        }
        return value;
    }

    @Override
    public void display() {
        Node<K, V> aux = head;
        while (aux != null) {
            System.out.print(aux.value + " -> ");
            aux = aux.next;
        }
        System.out.println("null");
    }

    private void moveNodeToHead(Node<K, V> node) {
        if (node != head) {
            // only then rearrange
            node.prev.next = node.next;
            if (node != tail) {
                node.next.prev = node.prev;
            } else {
                tail = node.prev;
            }
            node.next = null;
            node.prev = null;
            // Till here, the node has been completely extracted from the LinkedList

            // Now add the Node to the start of LinkedList:
            addToHead(node);
        }
    }

    private void addToHead(Node<K, V> node) {
        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
}

class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;
    Node<K, V> prev;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}