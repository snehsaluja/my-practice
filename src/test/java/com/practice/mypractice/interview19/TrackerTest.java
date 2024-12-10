package com.practice.mypractice.interview19;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrackerTest {
    //@BeforeEach
    public Tracker initTracker() {
        Tracker tracker = new Tracker();

        tracker.insert(5);
        tracker.insert(5);
        tracker.insert(5);
        tracker.insert(6);
        tracker.insert(7);
        tracker.insert(4);
        tracker.insert(3);
        return tracker;
    }

    @Test
    public void shouldInsertSuccessfully() {
        Tracker tracker = initTracker();
        // check if count = 7, sum = 35, size of pq = 5, pq.peek = 5 with freq 3
        Assertions.assertEquals(tracker.freqMap.size(), 5);
    }

    @Test
    public void shouldTestGetMax() {
        Tracker tracker = initTracker();
        Assertions.assertEquals(tracker.getMax(), 7);
    }

    @Test
    public void shouldTestGetMin() {
        Tracker tracker = initTracker();
        Assertions.assertEquals(tracker.getMin(), 3);
    }

    @Test
    public void shouldTestGetAverage() {
        Tracker tracker = initTracker();
        Assertions.assertEquals(tracker.getAverage(), 5.00d, 0.0);
    }

    @Test
    public void shouldTestGetMode() {
        Tracker tracker = initTracker();
        Assertions.assertEquals(tracker.getMode(), 5);
    }


    @Test
    public void shouldTestGetModeWithMultipleModes() {
        Tracker tracker = initTracker();
        tracker.insert(7);
        tracker.insert(7);
        Assertions.assertEquals(tracker.getMode(), 5);
    }
}
