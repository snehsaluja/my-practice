package com.practice.mypractice.interview4;

import com.practice.mypractice.interview4.cache.LRUCache;

public class CacheDriver {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache();

        cache.put(1, "Hello");
        cache.display();
        cache.put(2, "World");
        cache.display();
        cache.put(3, "Bye");
        cache.display();
        cache.put(4, "Good Morning");
        cache.display();
        cache.put(5, "Good night");
        cache.display();
        cache.put(6, "Good day");
        cache.display();
        cache.get(3);
        cache.display();
    }
}
