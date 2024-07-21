package com.practice.mypractice.programs.cache;

public class MainClass {

    public static void main(String[] args) {
        Cache<Integer, String> cache = new LRUCache2<>();
        cache.put(1, "ABC");
        cache.put(2, "Sneh");
        cache.put(3, "Bhavana");
        cache.put(4, "XYZ");
        cache.put(5, "Viju");
        cache.display();
        cache.put(6, "Ankur");
        cache.display();
        cache.get(3);
        cache.display();
        cache.get(2);
        cache.display();
        cache.put(7, "Tulika");
        cache.display();
        cache.put(8, "Mileen");
        cache.display();
        cache.put(3, "BHAVANAAAAA");
        cache.display();
    }
}
