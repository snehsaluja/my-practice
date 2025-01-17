package com.practice.mypractice.interview32;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// Company Name: Multiplier
/*
Question
You are given a 2D 0-indexed array of strings, access_times, with size n. For each i where 0 <= i <= n - 1, access_times[i][0] represents the name of an employee, and access_times[i][1] represents the access time of that employee. All entries in access_times are within the same day.
The access time is represented as four digits using a 24-hour time format, for example, "0800" or "2250".
An employee is said to be high-access if he has accessed the system three or more times within a one-hour period.
Times with exactly one hour of difference are not considered part of the same one-hour period. For example, "0815" and "0915" are not part of the same one-hour period.
Access times at the start and end of the day are not counted within the same one-hour period. For example, "0005" and "2350" are not part of the same one-hour period.
Return a list that contains the names of high-access employees with any order you want.
Example 1
        [["a", "1010"], ["b", "1015"], ["a", "1020"], ["a", "1030"]] → ["a"]
Example 2
        [["a", "1000"], ["a", "1030"], ["a", "1100"], ["a", "1130"]] → []
Example 3
        [["a", "1030"], ["a", "1230"], ["a", "1010"], ["a", "1200"], ["a", "1020"]] → ["a"]

*/

public class Solution {

    public static void main(String[] args) {
        Solution ob = new Solution();
        System.out.println(ob.getHighAccessEmployees(new String[][]{{"a", "1010"}, {"b", "1015"}, {"a", "1020"}, {"a", "1030"}}));
        System.out.println(ob.getHighAccessEmployees(new String[][]{{"a", "1010"}, {"b", "1015"}, {"a", "1020"}, {"a", "1230"}}));
    }

    public List<String> getHighAccessEmployees(String[][] arr) {
        List<String> result = new ArrayList<>();

        Map<String, List<String>> employeeTimeMap = new HashMap<>();

        for (String[] emp : arr) {
            String employeeName = emp[0];
            String time = emp[1];
            employeeTimeMap.computeIfAbsent(employeeName, k -> new ArrayList<>()).add(time);
        }

        for (Map.Entry<String, List<String>> entry : employeeTimeMap.entrySet()) {
            String employeeName = entry.getKey();
            List<String> time = entry.getValue();
            // Collections.sort(time); // Comment this if we want to check for the next day as well. example -> [2355, 0010, 0015]
            isHighAccess(employeeName, time, result);
        }
        return result;
    }

    private void isHighAccess(String employeeName, List<String> time, List<String> result) {
        for (int i = 0; i < time.size() - 2; i++) {
            if (isWithinRange2(time.get(i), time.get(i + 2))) {
                result.add(employeeName);
                break;
            }
        }
    }

    private boolean isWithinRange(String s1, String s2) {
        int time1 = Integer.parseInt(s1);
        int time2 = Integer.parseInt(s2); //+2400

        // Enhancement to check if it's in the next day
        if (time2 < time1) {
            time2 += 2400;
        }

        // 1100 & 1130 => < 60
        // 1150 & 1220 => < 100 (within 1 hour range)
        return time2 - time1 < 100;
    }
    // 1115 & 1215 === 100

    private boolean isWithinRange2(String s1, String s2) {
        LocalTime t1 = LocalTime.of(Integer.parseInt(s1.substring(0, 2)), Integer.parseInt(s1.substring(2)));
        LocalTime t2 = LocalTime.of(Integer.parseInt(s2.substring(0, 2)), Integer.parseInt(s2.substring(2)));
        if (t2.isBefore(t1.plusHours(1))) {
            return true;
        }
        return false;
    }

}
