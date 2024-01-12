package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DestinationCity {

    public static void main(String[] args) {

    }

    public String destCityOptimized(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (!set.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }

    public String destCity(List<List<String>> paths) {
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> dest = new HashSet<>();
        for (List<String> path : paths) {
            map.put(path.get(0), map.getOrDefault(path.get(0), 0) + 1);
            map.put(path.get(1), map.getOrDefault(path.get(1), 0) + 1);
            dest.add(path.get(1));
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1 && dest.contains(entry.getKey())) {
                return entry.getKey();
            }
        }
        return "";
    }
}
