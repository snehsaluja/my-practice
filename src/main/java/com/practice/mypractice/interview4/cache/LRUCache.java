package com.practice.mypractice.interview4.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache implements Cache {

    private static final int N = 5;

    LinkedHashMap<Integer, String> cache;

    public LRUCache() {
        cache = new LinkedHashMap<>();
    }

/*
    public int hashCode(int key) {
        return key % N;
    }
*/

    public String get(int key) {
        String val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
        return val;
    }

    public boolean put(int key, String value) {

        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
            return false;
        }

        if (cache.size() >= N) {
            Map.Entry<Integer, String> entry = null;
            entry = cache.entrySet().stream().findFirst().get();
            int k = (int) entry.getKey();
            cache.remove(k);
        }

        cache.put(key, value);

        return true;
    }

    public void display() {
        for (Map.Entry<Integer, String> entry : cache.entrySet()) {
            System.out.print(entry.getKey() + ":" + entry.getValue() + " -> ");
        }
        System.out.println();
    }


}
