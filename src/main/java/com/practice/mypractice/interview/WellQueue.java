package com.practice.mypractice.interview;

public class WellQueue {
    public int getFirstPersonInTheQueue(int n) {

        int remainingNumberOfDrinkers = n;
        int cycles = -1, numberOfUniquePersons = 5, k = 0, oldVal;
        int cutValue = 5;
        while (remainingNumberOfDrinkers > 0) {
            cycles++;
            k = k + (int) (Math.pow(2, cycles));
            //oldVal = remainingNumberOfDrinkers;
            if (remainingNumberOfDrinkers - cutValue < 0) {
                break;
            }
            remainingNumberOfDrinkers -= cutValue;
            cutValue *= 2;
        }
        int totalDuplicatesForEachPerson = (int) Math.pow(2, cycles);
        return (remainingNumberOfDrinkers / totalDuplicatesForEachPerson) + 1;

        //  2^cycles = total number of 1s 2s 3s 4s and 5s
        /*int totalDuplicatesForEachPerson = (int) Math.pow(2, cycles);
        int remainingNumberOfIterations = Math.abs(n - (totalDuplicatesForEachPerson * 5));
        return remainingNumberOfIterations / totalDuplicatesForEachPerson + 1;*/
    }

    public static void main(String[] args) {
        WellQueue ob = new WellQueue();
        System.out.println(ob.getFirstPersonInTheQueue(1));
        System.out.println(ob.getFirstPersonInTheQueue(2));
        System.out.println(ob.getFirstPersonInTheQueue(3));
        System.out.println(ob.getFirstPersonInTheQueue(4));
        System.out.println(ob.getFirstPersonInTheQueue(5));
        System.out.println(ob.getFirstPersonInTheQueue(6));
        System.out.println(ob.getFirstPersonInTheQueue(7));
        System.out.println(ob.getFirstPersonInTheQueue(8));
        System.out.println(ob.getFirstPersonInTheQueue(9));
        System.out.println(ob.getFirstPersonInTheQueue(10));
        System.out.println(ob.getFirstPersonInTheQueue(11));
        System.out.println(ob.getFirstPersonInTheQueue(12));
        System.out.println(ob.getFirstPersonInTheQueue(13));
        System.out.println(ob.getFirstPersonInTheQueue(14));
        System.out.println(ob.getFirstPersonInTheQueue(15));
        System.out.println(ob.getFirstPersonInTheQueue(16));
        System.out.println(ob.getFirstPersonInTheQueue(17));
        System.out.println(ob.getFirstPersonInTheQueue(18));
        System.out.println(ob.getFirstPersonInTheQueue(19));
        System.out.println(ob.getFirstPersonInTheQueue(20));
    }
}





/*

    Queue with 5 people. = M
        Magical Well: Person in the front of Q drinks water from this well and doubles and goes to the end of the Q




        Input: N[1, N]: number of people drinking water from the well
        Output: [1,5]: After N persons drink water from the well who is in the front?


        Q: 1(Front),2,3,4,5(Rear)
        Q: 2,3,4,5,1,1

        Q: 1,1,2,2,3,3,4,4,5,5

        Q: 1,2,3,4,5
        N = 3
        Output = 4

        N/5 = 2^(N/5 + 1) * M = O(M)
        N = 1..5 => Space O(2M) = O(M)
        N = 6..10 => Space O(4M) = O(M)
        N = 11..15 => Space O(8M) = O(M)

        X =
        5, 10 , 20 , 40 , 80….
        5, 15 , 35 , 75 ,  => 1,3,7,15
        Int k = 1;
// 5 * 1 ;;;; (2^k)
        5 * 3; 5* (2^1) + 5

        30/16 + 1 = 2

        N = 85 ; 80 ; 70 ; 50 ; 10
        N = 1..4 => (N+1)
        N = 5..14 =>
        5,6 => 1; 6/5 = 1 ; 5/5
        7,8 => 2 ; 8
        9,10 =>3
        11,12 => 4
        13,14 => 5
        N = 15..N =>
        Public int getFirstPersonInTheQueue(int n){

        Int totalNumberOfDrinkers = n;
        Int cycles = 0;
        while(totalNumberOfDrinkers){

        }
// while(totalNumberOfDrinkers > quotient)


*/
