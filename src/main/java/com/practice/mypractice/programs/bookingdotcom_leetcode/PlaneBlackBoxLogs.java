package com.practice.mypractice.programs.bookingdotcom_leetcode;

/*
Say we got the black box from airoplace crach, There is huge set of log files with contents unsorted. We need to fetch the lastet half an hour log. desig an suitable algorithm to fetch lastest half an hour log statement. the formate of log statement would be
        <DD-MM-YYYY HH:MM:SS:sss> <LogStatement>
example - 02-01-2014 10:02:01:001 abcd
*/

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaneBlackBoxLogs {

    @AllArgsConstructor
    class Log {
        private LocalDateTime dateTime;
        private String logStatement;

        @Override
        public String toString() {
            return "Log{" +
                    "dateTime=" + dateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)) +
                    ", logStatement='" + logStatement + '\'' +
                    '}';
        }
    }

    private static final String DATE_TIME_PATTERN = "dd-MM-yyyy HH:mm:ss:SSS";

    public List<Log> getLatest30MinsLogs(List<String> logs, int minutesWindow) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
        List<Log> logList = new ArrayList<>();
        for (String l : logs) {
            int indexOfSecondSpace = l.indexOf(' ', l.indexOf(' ') + 1);
            String timeStamp = l.substring(0, indexOfSecondSpace);
            String statement = l.substring(indexOfSecondSpace + 1);
            logList.add(new Log(LocalDateTime.parse(timeStamp, dtf), statement));
        }
        logList.sort((o1, o2) -> o2.dateTime.compareTo(o1.dateTime));
        LocalDateTime start = logList.get(0).dateTime, windowEnd = start.minusMinutes(minutesWindow);
        int i = 1;
        while (i < logList.size() && logList.get(i).dateTime.isAfter(windowEnd)) {
            i++;
        }
        return logList.subList(0, i);
    }

    public static void main(String[] args) {
        List<String> logs = Arrays.asList(
                "02-01-2014 10:02:01:001 Log statement 1",
                "02-01-2014 10:05:01:001 Log statement 2",
                "02-01-2014 10:30:00:000 Log statement 3",
                "02-01-2014 10:31:00:000 Log statement 4",
                "02-01-2014 09:59:59:999 Log statement 5",
                "02-01-2014 09:59:58:999 Log statement 6",
                "02-01-2014 07:59:57:999 Log statement 7",
                "02-01-2014 09:59:56:999 Log statement 8",
                "02-01-2014 09:59:59:399 Log statement 9",
                "02-01-2014 10:29:00:000 Log statement 10",
                "02-01-2014 10:27:00:000 Log statement 11",
                "02-01-2014 10:29:50:000 Log statement 12",
                "02-01-2014 10:19:30:000 Log statement 13",
                "02-01-2014 10:27:57:000 Log statement 14"
        );
        PlaneBlackBoxLogs ob = new PlaneBlackBoxLogs();
        List<Log> latestLogs = ob.getLatest30MinsLogs(logs, 30); // 30 minutes window
        latestLogs.forEach(System.out::println);
    }
}
