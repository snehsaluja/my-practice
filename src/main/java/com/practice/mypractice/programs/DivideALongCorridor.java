package com.practice.mypractice.programs;

public class DivideALongCorridor {

    static final int MOD = (int) (1e9 + 7);

    public static int numberOfWays(String corridor) {

        char[] chars = corridor.toCharArray();
        int totalSeatCount = 0;
        long prevSeatIndex = -1, totalWays = 1;
        for (int index = 0; index < chars.length; index++) {
            if (chars[index] == 'S') {
                totalSeatCount++;
                if (totalSeatCount > 2 && (totalSeatCount % 2) == 1) {
                    totalWays = ((totalWays % MOD) * ((index - prevSeatIndex) % MOD)) % MOD;
                }
                prevSeatIndex = index;
            }
        }
        return (totalSeatCount > 0 && (totalSeatCount % 2) == 0) ? (int) totalWays : 0;
    }

    public int numberOfWaysOptimized(String corridor) {

        char[] array = corridor.toCharArray();
        int chairs = 0;
        long result = 1;

        for (int i = 0; i < array.length; i++) {

            // seat encountered
            if (array[i] == 'S') {
                chairs++;

                // advance to the next seat ignoring plants along the way
                while (++i < array.length && array[i] != 'S');
                if (i < array.length && array[i] == 'S') {
                    chairs++;
                }


                // there is one guaranteed division between adjacent pairs of seats
                // each plant between them adds an extra 1 division
                int divisions = 1;
                while (++i < array.length && array[i] != 'S') {
                    divisions++;
                }

                // if any extra divisions are possible, multiply our result by the divisions
                if (divisions > 1 && i < array.length) {
                    result = (result * divisions) % 1000000007;
                }
                i--;
            }
        }

        // if there are no chairs or an odd number of chairs there are no possible divisions
        // otherwise return our calculated result
        return (chairs != 0 && chairs % 2 == 0) ? (int) result : 0;
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays("SPPSSSSPPS"));     // EXPECTED 1
        System.out.println(numberOfWays("PPSPSP"));
        System.out.println(numberOfWays("SSPPSPS"));
        System.out.println(numberOfWays("S"));
        System.out.println(numberOfWays("P"));
        System.out.println(numberOfWays("SPPPSPPPPP"));
        System.out.println(numberOfWays("PPPSSSPPPS"));
        System.out.println(numberOfWays("PPPSSSPPP"));
        System.out.println(numberOfWays("PPPSSPSPPPS"));
        System.out.println(numberOfWays("SPSPPSSPSSSS"));       // EXPECTED 6
        System.out.println(numberOfWays("PPPPPPPSPPPSPPPPSPPPSPPPPPSPPPSPPSPPSPPPPPSPSPPPPPSPPSPPPPPSPPSPPSPPPSPPPPSPPPPSPPPPPSPSPPPPSPSPPPSPPPPSPPPPPSPSPPSPPPPSPPSPPSPPSPPPSPPSPSPPSSSS"));       // EXPECTED 18335643
    }
}
