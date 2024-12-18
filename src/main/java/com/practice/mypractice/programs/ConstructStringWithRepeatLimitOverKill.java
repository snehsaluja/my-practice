package com.practice.mypractice.programs;

import java.util.PriorityQueue;

public class ConstructStringWithRepeatLimitOverKill {

    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<CharCount> pq = new PriorityQueue<>((a, b) -> {
            if (a.ch == b.ch) {
                return b.freq - a.freq;
            }
            return b.ch - a.ch;
        });

        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                pq.offer(new CharCount((char) (i + 'a'), freq[i]));
        }
        StringBuilder sb = new StringBuilder(" ");
        while (!pq.isEmpty()) {
            CharCount cc = pq.poll();
            if (sb.charAt(sb.length() - 1) != cc.ch) {
                appendChars(sb, cc.ch, Math.min(repeatLimit, cc.freq));
                cc.freq -= Math.min(repeatLimit, cc.freq);
                if (cc.freq > 0)
                    pq.offer(cc);
            } else if (!pq.isEmpty()) {
                CharCount nextCc = pq.poll();
                appendChars(sb, nextCc.ch, Math.min(repeatLimit, 1));
                nextCc.freq -= Math.min(repeatLimit, 1);
                if (nextCc.freq > 0)
                    pq.offer(nextCc);
                pq.offer(cc);
            } else {
                break;
            }
        }

        return sb.toString().trim();
    }

    private void appendChars(StringBuilder sb, char ch, int repeatLimit) {
        while (repeatLimit-- > 0) {
            sb.append(ch);
        }
    }

    class CharCount {
        char ch;
        int freq;

        public CharCount(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public static void main(String[] args) {
        ConstructStringWithRepeatLimitOverKill ob = new ConstructStringWithRepeatLimitOverKill();
        System.out.println(ob.repeatLimitedString("cczazcc", 3));
    }
}
