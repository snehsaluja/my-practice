package com.practice.mypractice.programs;
import java.util.*;

public class OctaviaLunarPhase {
    static final String[] PHASES = {
            "NewMoon", "Crescent", "Quarter", "Gibbous",
            "Full", "Waning", "Eclipse", "Twilight"
    };

    static final Map<String, Integer> MONTH_DAYS = new LinkedHashMap<>();
    static {
        MONTH_DAYS.put("January", 31);
        MONTH_DAYS.put("February", 28);
        MONTH_DAYS.put("March", 31);
        MONTH_DAYS.put("April", 30);
        MONTH_DAYS.put("May", 31);
        MONTH_DAYS.put("June", 30);
        MONTH_DAYS.put("July", 31);
        MONTH_DAYS.put("August", 31);
        MONTH_DAYS.put("September", 30);
        MONTH_DAYS.put("October", 31);
        MONTH_DAYS.put("November", 30);
        MONTH_DAYS.put("December", 31);
    }

    public static String solution(String season, int dayCount, String initialPhase) {
        // Calculate the day of year for given season and dayCount
        int daysSinceStart = 0;
        for (String month : MONTH_DAYS.keySet()) {
            if (month.equals(season)) break;
            daysSinceStart += MONTH_DAYS.get(month);
        }
        daysSinceStart += (dayCount - 1); // zero-based day offset

        // Find index of initial phase
        int startIndex = Arrays.asList(PHASES).indexOf(initialPhase);
        int phaseIndex = (startIndex + daysSinceStart) % PHASES.length;

        return PHASES[phaseIndex];
    }

    public static void main(String[] args) {
        System.out.println(solution("January", 4, "Full"));      // Output: Twilight
        System.out.println(solution("February", 4, "Crescent")); // Output: Gibbous
    }
}