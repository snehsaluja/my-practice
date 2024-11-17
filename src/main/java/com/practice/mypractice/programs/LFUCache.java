package com.practice.mypractice.programs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {

    private Map<Integer, Element> map;
    private PriorityQueue<Element> pq;
    private final int capacity;
    private int timer;

    public LFUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.frequency == o2.frequency) {
                return o2.lastUsed - o1.lastUsed;
            }
            return o1.frequency - o2.frequency;
        });
        this.capacity = capacity;
        this.timer = 0;
    }

    public int get(int key) {
        Element e = map.get(key);
        if (e != null) {
            pq.remove(e);
            e.frequency++;
            e.lastUsed = ++timer;
            pq.offer(e);
            return e.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Element e = map.get(key);
        if (e != null) {
            pq.remove(e);
            e.frequency++;
            e.lastUsed = ++timer;
            e.value = value;
            pq.offer(e);
        } else {
            Element newElement = new Element();
            newElement.key = key;
            newElement.value = value;
            newElement.frequency = 0;
            newElement.lastUsed = ++timer;
            if (map.size() >= capacity) {
                Element removableElement = pq.remove();
                map.remove(removableElement.key);
            }
            map.put(key, newElement);
            pq.offer(newElement);
        }
    }

    static class Element {
        int key;
        int value;
        int frequency;
        int lastUsed;
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }
}
