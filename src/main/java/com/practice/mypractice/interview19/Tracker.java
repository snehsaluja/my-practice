package com.practice.mypractice.interview19;

/*

New Relic Interview :

Programming Round :

You want to measure the performance of a web application by tracking the response time of an endpoint.

Write a class Tracker with these methods:

insert - records a response time
getMax - returns the highest response time seen so far
getMin — returns the lowest response time seen so far
getAverage - the average of all response times seen so far
getMode — returns the mode of all response times seen so far
Optimize for space and time. Favor speeding up the getter methods getMax, getMin, getAverage, and getMode over speeding up the insert method.

getAverage should return a double, but the rest of the getter methods can return integers. Response times will all be inserted as integers with a range of 1 to 200.

If there is more than one mode, return any of the modes.
*/



import java.util.HashMap;
import java.util.Map;


public class Tracker {

    //public PriorityQueue<ResponseFreq> pq = new PriorityQueue<>(Comparator.comparingInt(k -> k.getFrequency()));
    public Map<Integer, Integer> freqMap = new HashMap<>();
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;
    private int sum = 0;
    private int count = 0;
    private int maxFreq = 0;
    private int mode = 0;

    public void insert(int response){
        max = Math.max(max, response);
        min = Math.min(min, response);
        sum += response;
        count++;
        freqMap.put(response, freqMap.getOrDefault(response, 0)+1);

        if (freqMap.get(response) > maxFreq){
            maxFreq = freqMap.get(response);
            mode = response;
        }
        /*
        ResponseFreq rf = null;
        if (freqMap.containsKey(response)){
          rf = freqMap.get(response);
          pq.remove(rf);
          rf.frequency++;
        } else {
          rf = new ResponseFreq(response, 1);
          freqMap.put(response, rf);
        }
        pq.offer(rf);
        */
    }

    public int getMax(){
        return max;
    }

    public int getMin(){
        return min;
    }

    public double getAverage(){
        return ((double) sum/count);
    }

    public int getMode() {
        return mode;
        /*ResponseFreq resFreq = pq.peek();
        return resFreq.getResponseTime();*/
    }

}
/*
class ResponseFreq {
  public int responseTime;
  public int frequency;

  ResponseFreq(){

  }
  ResponseFreq(int responseTime, int frequency){
    this.responseTime = responseTime;
    this.frequency = frequency;
  }

  public int getResponseTime() {
    return responseTime;
  }

  public int getFrequency(){
    return frequency;
  }
}*/


/*

TEST CLASS WRITTEN DURING THE INTERVIEW:
************************************

import static org.junit.Assert.*;
import org.junit.Test;

public class TrackerTest
{
    //@BeforeEach
    public Tracker initTracker(){
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
        assertEquals(tracker.freqMap.size(), 5);
    }

    @Test
    public void shouldTestGetMax(){
        Tracker tracker = initTracker();
        assertEquals(tracker.getMax(), 7);
    }

    @Test
    public void shouldTestGetMin(){
        Tracker tracker = initTracker();
        assertEquals(tracker.getMin(), 3);
    }

    @Test
    public void shouldTestGetAverage(){
        Tracker tracker = initTracker();
        assertEquals(tracker.getAverage(), 5.00d, 0.0);
    }

    @Test
    public void shouldTestGetMode(){
        Tracker tracker = initTracker();
        assertEquals(tracker.getMode(), 5);
    }


    @Test
    public void shouldTestGetModeWithMultipleModes(){
        Tracker tracker = initTracker();

        assertEquals(tracker.getMode(), 5);
    }



}
*/
