package com.practice.mypractice.programs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountUserLogins {

    public static void main(String[] args) {

    }

    public static List<List<String>> countUserLogins(List<List<String>> logs) {

        Map<String, Map<String, Integer>> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (List<String> log : logs) {
            String user = log.get(0);
            String date = log.get(2);

            try {
                sdf.parse(date);
            } catch (Exception e) {
                continue;
            }

            map.putIfAbsent(user, new HashMap<>());
            Map<String, Integer> userDateMap = map.get(user);
            userDateMap.put(date, userDateMap.getOrDefault(date, 0) + 1);
        }
        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            String key = entry.getKey();
            Map<String, Integer> dataCountMap = entry.getValue();
            for (Map.Entry<String, Integer> integerEntry : dataCountMap.entrySet()) {
                List<String> l = new ArrayList<>();
                l.add(key);
                l.add(integerEntry.getKey());
                l.add(integerEntry.getValue().toString());
            }
        }
        result.sort((o1, o2) -> {
            if (o1.get(0).equals(o2.get(0))) {
                return o1.get(1).compareTo(o2.get(1));
            }
            return Integer.parseInt(o1.get(0).substring(4)) - Integer.parseInt(o2.get(0).substring(4));
        });
        return result;
    }
}
