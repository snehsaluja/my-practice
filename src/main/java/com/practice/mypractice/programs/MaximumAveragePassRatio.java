package com.practice.mypractice.programs;

import java.util.PriorityQueue;

public class MaximumAveragePassRatio {

    public static void main(String[] args) {

    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        double totalRatio = 0;

        PriorityQueue<ClassRecord> pq = new PriorityQueue<>((a, b) -> {
            if (b.gain - a.gain < 0.0) {
                return -1;
            }
            if (b.gain - a.gain > 0.0) {
                return 1;
            }
            return 0;
        });

        for (int i = 0; i < n; i++) {
            pq.offer(new ClassRecord(classes[i]));
        }

        while (extraStudents-- > 0) {
            pq.offer(pq.poll().addOneStudent());
        }

        while (!pq.isEmpty()) {
            ClassRecord classRecord = pq.poll();
            totalRatio += (classRecord.pass / (double) classRecord.total);
        }
        return totalRatio / (double) n;
    }

    class ClassRecord {
        int pass;
        int total;
        double gain;

        /*public ClassRecord(int pass, int total, double gain) {
            this.pass = pass;
            this.total = total;
            this.gain = gain;
        }*/

        public ClassRecord(int[] arr) {
            this.pass = arr[0];
            this.total = arr[1];
            this.gain = ((pass + 1) / (double) (total + 1)) - (pass / (double) total);
        }

        public ClassRecord addOneStudent() {
            pass++;
            total++;
            gain = ((pass + 1) / (double) (total + 1)) - (pass / (double) total);
            return this;
        }
    }

}
