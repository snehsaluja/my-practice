package com.practice.mypractice.interview4.cache;

public interface Cache {
    public String get(int key);

    public boolean put(int key, String value);


    public void display();
}
