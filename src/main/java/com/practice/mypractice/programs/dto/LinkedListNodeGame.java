package com.practice.mypractice.programs.dto;

public class LinkedListNodeGame {

    public int val;
    public LinkedListNodeGame next;
    public int win_count;
    public boolean goneAtLast;

    public LinkedListNodeGame(int num) {
        val = num;
        win_count = 0;
    }
}
