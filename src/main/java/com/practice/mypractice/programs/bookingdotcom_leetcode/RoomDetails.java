package com.practice.mypractice.programs.bookingdotcom_leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Data
public class RoomDetails {

    int price;
    Set<String> features;
    int availability;

    /*
    {
        "price" : 260,
        "features" : ["breakfast", "refundable"],
        "availbility" : 3
    }
    */

}
