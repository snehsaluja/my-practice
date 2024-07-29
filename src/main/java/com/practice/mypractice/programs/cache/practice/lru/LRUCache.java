package com.practice.mypractice.programs.cache.practice.lru;

import com.practice.mypractice.programs.cache.practice.Cache;

import java.util.Map;

public class LRUCache<K, V> implements Cache<K, V> {

    private Map<K, Node<K, V>> cacheMap;

    private Node<K, V> lruHead, lruTail;

    private static final int MAX_LIMIT = 5;

    @Override
    public void put(K key, V value) {
        Node<K, V> node;
        if (cacheMap.containsKey(key)) {
            node = cacheMap.get(key);
            node.value = value;
            moveNodeToHead(node);
        } else {
            evictRecentlyUsedKey();
            node = new Node<>(key, value);
            addToHead(node);
        }
        cacheMap.put(key, node);
    }

    private void addToHead(Node<K, V> node) {
        node.next = lruHead;
        node.prev = null;
        if (lruHead != null) {
            lruHead.prev = node;
        } else {                // inserting the first node
            lruTail = node;
        }
        lruHead = node;
    }

    private void moveNodeToHead(Node<K, V> node) {
        if (node != lruHead) {
            node.prev.next = node.next;
            if (node != lruTail) {
                node.next.prev = node.prev;
            } else {
                lruTail = node.prev;
            }
            node.next = lruHead;
            node.prev = null;
            lruHead.prev = node;
            lruHead = node;
        }
    }

    private void evictRecentlyUsedKey() {
        if (cacheMap.size() >= MAX_LIMIT) {                 // removing tail node from the list
            K removableKey = lruTail.key;
            lruTail = lruTail.prev;
            lruTail.next = null;
            cacheMap.remove(removableKey);
        }
    }

    @Override
    public V get(K key) {
        V returnableValue = null;
        if (cacheMap.containsKey(key)) {
            Node<K, V> node = cacheMap.get(key);
            returnableValue = node.value;
            moveNodeToHead(node);
        }
        return returnableValue;
    }

    @Override
    public V evict(K key) {
        V returnableValue = null;
        if (cacheMap.containsKey(key)) {
            Node<K, V> node = cacheMap.get(key);
            returnableValue = node.value;
            deleteFromList(node);
        }
        return returnableValue;
    }

    private void deleteFromList(Node<K, V> node) {
        if (node == lruHead) {
            lruHead = node.next;
            lruHead.prev = null;
            node.next = null;
        }
        if (node == lruTail) {
            lruTail = node.prev;
            lruTail.next = null;
            node.prev = null;
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