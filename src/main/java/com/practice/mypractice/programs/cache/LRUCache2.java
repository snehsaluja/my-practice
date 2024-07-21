package com.practice.mypractice.programs.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class LRUCache2<K, V> implements Cache<K, V> {

    LinkedHashMap<K, V> cacheMap = new LinkedHashMap<>();
    private static final int CAPACITY = 5;

    @Override

    public V get(K key) {
        V value = null;
        if (cacheMap.containsKey(key)) {
            value = cacheMap.get(key);
            cacheMap.remove(key);
            cacheMap.put(key, value);
        }
        return value;
    }

    @Override
    public void put(K key, V value) {
        if (cacheMap.containsKey(key)) {
            cacheMap.remove(key);
        } else {
            if (cacheMap.size() == CAPACITY) {
                // remove from first
                Map.Entry<K, V> entry = cacheMap.entrySet().stream().findFirst().get();
                K removeKey = entry.getKey();
                cacheMap.remove(removeKey);
            }
        }
        cacheMap.put(key, value);
    }

    @Override
    public void display() {
        cacheMap.forEach((key, value) -> System.out.print(value + " -> "));
        System.out.println("null");
    }
}
