package com.practice.mypractice.programs.bookingdotcom_leetcode;

/*

Data set to work on =>

    {
        176 : 	[
            {
                "price" : 120,
                "features" : ["breakfast", "refundable"],
                "availbility" : 5
            }
        ],
        177 : 	[
            {
                "price" : 130,
                "features" : ["breakfast"],
                "availbility" : 1
            },
            {
                "price" : 140,
                "features" : ["breakfast", "refundable", "wifi"],
                "availbility" : 3
            }
        ],
        178 : 	[
            {
                "price" : 130,
                "features" : ["breakfast"],
                "availbility" : 2
            },
            {
                "price" : 140,
                "features" : ["breakfast", "refundable", "wifi"],
                "availbility" : 10
            }
        ]
    }
Given above data map set, design an algorithm to get below output for below given input


I/P =>
        {
            "checkin" : 176,
            "checkout" : 178,
            "features" : ["breakfast"]
            "rooms"    : 1
        }

o/P =>
        [
            {
                "price" : 250,
                "features" : ["breakfast"],
                "availbility" : 1
            },
            {
                "price" : 260,
                "features" : ["breakfast", "refundable"],
                "availbility" : 3
            }
        ]
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class QueryHotels {

    Map<Integer, List<RoomDetails>> roomAvailabilityMap;

    QueryHotels(Map<Integer, List<RoomDetails>> roomAvailabilityMap) {
        this.roomAvailabilityMap = roomAvailabilityMap;
    }

    public List<RoomDetails> getAvailability(int checkin, int checkout, List<String> features, int rooms) {
        Queue<RoomDetails> queue = new LinkedList<>();
        for (int i = checkin; i < checkout; i++) {
            List<RoomDetails> roomDetails = roomAvailabilityMap.get(i);
            List<RoomDetails> filteredList = roomDetails.stream()
                    .filter(rm -> rooms <= rm.availability && new HashSet<>(rm.features).containsAll(features))
                    .collect(Collectors.toList());
            if (i == checkin) {
                queue.addAll(filteredList);
            } else {
                int size = queue.size();
                while (size-- > 0) {
                    RoomDetails room = queue.poll();
                    for (int j = 0; j < filteredList.size(); j++) {
                        RoomDetails currentRoom = filteredList.get(j);
                        int price = currentRoom.price + room.price;
                        Set<String> commonFeatures = getCommonFeatures(room, currentRoom);
                        int av = Math.min(room.availability, currentRoom.availability);
                        RoomDetails newRoom = new RoomDetails(price, commonFeatures, av);
                        queue.offer(newRoom);
                    }
                }
            }

        }

        return new ArrayList<>(queue);
    }

    private Set<String> getCommonFeatures(RoomDetails room1, RoomDetails room2) {
        Set<String> featuresList = new HashSet<>();

        for (String str : room1.features) {
            if (room2.features.contains(str)) {
                featuresList.add(str);
            }
        }
        return featuresList;
    }

    public static void main(String[] args) {
        // Mutable Set:
        // Set<String> set = new HashSet<>(Arrays.asList("breakfast", "refundable"));

        // Immutable Set below:
        RoomDetails r1 = new RoomDetails(120, Set.of("breakfast", "refundable"), 5);
        RoomDetails r2 = new RoomDetails(130, Set.of("breakfast"), 1);
        RoomDetails r3 = new RoomDetails(140, Set.of("breakfast", "refundable", "wifi"), 3);
        RoomDetails r4 = new RoomDetails(130, Set.of("breakfast"), 2);
        RoomDetails r5 = new RoomDetails(140, Set.of("breakfast", "refundable", "wifi"), 10);
        Map<Integer, List<RoomDetails>> map = new HashMap<>();
        map.put(176, Arrays.asList(r1));
        map.put(177, Arrays.asList(r2, r3));
        map.put(178, Arrays.asList(r4, r5));

        QueryHotels ob = new QueryHotels(map);
        List<RoomDetails> queryResult = ob.getAvailability(176, 178, Arrays.asList("breakfast"), 1);
        System.out.println(queryResult);
    }

}
