package com.practice.mypractice.programs;

import java.util.BitSet;

public class SeatManagerBitWise {

    BitSet bs;

    public SeatManagerBitWise(int n) {
        bs = new BitSet(n);
    }

    public int reserve() {
        int i = bs.nextClearBit(1);
        bs.set(i);
        return i;
    }

    public void unreserve(int seatNumber) {
        bs.clear(seatNumber);
    }
}