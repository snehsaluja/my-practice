package com.practice.mypractice.interview12;


/*

NinjaCart:

# Generate the message from the integer stream, based on the number mapping in mobile num keypads
        # for example 1 is mapped with "abc", 2 is mapped with "def" and so on.
        # Input: 1122
        # Output: "be"
        # Input: 11112222
        # Output: "ad"
        # Input: 121
        # Output: "ada"

*/


/*

abc - 1
def - 2
ghi - 3
jkl - 4
mno - 5
pqr - 6
stu - 7
vwx - 8
yz - 9
*/

import java.util.HashMap;
import java.util.Map;

public class MobileKeypad {

    public String decodeMessage(String numbers) {
        StringBuilder output = new StringBuilder();
        char ch = numbers.charAt(0);
        int count = 1;
        for (int i = 1; i < numbers.length(); i++) {
            if (ch == numbers.charAt(i)) {
                count++;
            } else {
                char decodedChar = decodeCharacter(ch, count, map);
                output.append(decodedChar);
                count = 1;
                ch = numbers.charAt(i);
            }
        }
        char decodedChar = decodeCharacter(ch, count, map);
        output.append(decodedChar);

        return output.toString();
    }

    private char decodeCharacter(char ch, int count, Map<Integer, String> map) {
        String keyValue = map.get(ch - 48);
        int len = keyValue.length();
        int decodedNumber = count % keyValue.length();
        if (decodedNumber == 0) {
            return keyValue.charAt(len - 1);
        } else {
            return keyValue.charAt(decodedNumber - 1);
        }
    }

    Map<Integer, String> map = new HashMap<>();

    public void initMap() {
        map.put(1, "abc");
        map.put(2, "def");
        map.put(3, "ghi");
        map.put(4, "jkl");
        map.put(5, "mno");
        map.put(6, "pqr");
        map.put(7, "stu");
        map.put(8, "vwx");
        map.put(9, "yz");
    }


    public static void main(String[] args) {

        MobileKeypad obj = new MobileKeypad();
        obj.initMap();
        System.out.println(obj.decodeMessage("1122"));
        System.out.println(obj.decodeMessage("11112222"));
        System.out.println(obj.decodeMessage("121"));
        System.out.println(obj.decodeMessage("1452"));
    }

}
