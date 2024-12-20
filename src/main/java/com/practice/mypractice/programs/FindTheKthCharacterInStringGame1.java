package com.practice.mypractice.programs;

public class FindTheKthCharacterInStringGame1 {

    public char kthCharacter(int k) {
        String s = "a";

        while (s.length() < k) {
            char[] temp = s.toCharArray();
            for (int i = 0; i < temp.length; i++) {
                temp[i]++;
            }
            s = s + new String(temp);
            System.out.println(s);
        }
        return s.charAt(k - 1);
    }

    public char kthCharacter2(int k) {
        int count = Integer.bitCount(k - 1);
        return (char) (count + 'a');
    }

    public static void main(String[] args) {
        FindTheKthCharacterInStringGame1 ob = new FindTheKthCharacterInStringGame1();
        System.out.println(ob.kthCharacter(5));
        //System.out.println(ob.kthCharacter(10));
    }
}


/*

0000 - a (zero 1s)
0001 - b (one 1s)
0010 - b (one 1s)
0011 - c (two 1s)
0100 - b
0101 - c
0110 - c
0111 - d (three 1s)
1000 - b
1001 - c
1010 - c
1011 - d
1100 - c
1101 - d
1110 - d
1111 - e

* */