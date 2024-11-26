package com.practice.mypractice.interview16;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveDuplicateLetters {

    // Remove duplicate letters from a string:
    //  Input = baccaabbabcbaa
    // output = bac (in any order)

    // Follow up question:
    // return the output which is lexicographically before other sequeneces..
    // e.g. -
    // Input = baccaab
    // after removing dups, output could be => bac or acb (maintaining the sequence). hence lexicographically "acb" comes first..
    // hence output = acb


    public String removeDuplicateLetters(String s) {

        boolean[] seen = new boolean[26];
        // HashSet can be used for seen
        Map<Character, Integer> lastIndex = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastIndex.put(ch, i);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (seen[ch - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && ch < stack.peek() && lastIndex.get(stack.peek()) > i) {
                char poppedChar = stack.pop();
                seen[poppedChar - 'a'] = false;
            }
            stack.push(ch);
            seen[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
