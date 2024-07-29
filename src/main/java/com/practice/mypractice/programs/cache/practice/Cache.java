package com.practice.mypractice.programs.cache.practice;

public interface Cache<K, V> {

    void put(K key, V value);

    V get(K key);

    V evict(K key);

}
