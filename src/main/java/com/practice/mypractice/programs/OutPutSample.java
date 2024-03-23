package com.practice.mypractice.programs;

import java.util.Arrays;
import java.util.List;

public class OutPutSample {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        System.out.println("yo");

        List list = Arrays.asList(1, 2);
        List nums = list;
        
        nums.add(3.14);
    }
}
