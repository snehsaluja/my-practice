package com.practice.mypractice.programs;

public class SeatManager {

    boolean reservation[];
    int min = 1;
    int unreserved = 0;

    public SeatManager(int n) {
        reservation = new boolean[n + 1];
    }

    public int reserve() {
        if (unreserved == 0) {
            reservation[min] = true;
            return min++;
        }

        for (int i = 1; i <= reservation.length; i++) {
            if (!reservation[i]) {
                reservation[i] = true;
                unreserved--;
                return i;
            }
        }
        return -1;
    }

    public void unreserve(int seatNumber) {
        unreserved++;
        reservation[seatNumber] = false;
    }

/*
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });
    //List<String> unreservedSeatList;
    List<Seat> seatList;
    int n;

    public SeatManager(int n) {
        this.n = n;
        seatList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            seatList.add(new Seat(i + 1));
            pq.add(i + 1);
        }
    }

    public int reserve() {
        int emptySeatNumber = pq.poll();
        Seat emptySeatOb = seatList.get(emptySeatNumber - 1);
        emptySeatOb.status = "reserve";

        *//*for (int i = 0; i < seatList.size(); i++) {
            if (seat.equals("unreserve")) {
                seatList.remove(i);
                seatList.add(i, "reserve");
                return i + 1;
            }
        }*//*
        return emptySeatNumber;
    }

    public void unreserve(int seatNumber) {
        Seat s = seatList.get(seatNumber - 1);
        s.status = "unreserve";
        pq.add(seatNumber);
        *//*seatList.remove(seatNumber - 1);
        seatList.add(seatNumber - 1, "unreserve");*//*
    }

    class Seat {
        int seatNumber;
        String status;

        Seat(int num) {
            seatNumber = num;
            status = "unreserve";
        }
    }*/
}
