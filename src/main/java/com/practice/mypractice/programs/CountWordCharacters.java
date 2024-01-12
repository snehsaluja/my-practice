package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;

public class CountWordCharacters {

    public static int countCharacters2(String[] words, String chars) {

        int totalCharCount[] = new int[26];
        int totalLength = 0;
        for (char ch : chars.toCharArray()) {
            totalCharCount[ch - 'a']++;
        }

        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], totalCharCount)) {
                totalLength += words[i].length();
            }
        }
        return totalLength;
    }

    private static boolean canForm(String word, int[] totalCharCount) {
        int[] wordCharCount = new int[26];
        for (char ch : word.toCharArray()) {
            wordCharCount[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (wordCharCount[i] > totalCharCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charMap = new HashMap<>();

        for (char ch : chars.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        for (String str : words) {
            Map<Character, Integer> charMapDuplicate = new HashMap<>();
            boolean flag = true;
            for (char ch : str.toCharArray()) {
                if (charMap.containsKey(ch)) {
                    charMapDuplicate.put(ch, charMapDuplicate.getOrDefault(ch, 0) + 1);
                } else {
                    flag = false;
                    break;
                }
                for (Map.Entry<Character, Integer> entry : charMapDuplicate.entrySet()) {
                    if (entry.getValue() > charMap.get(entry.getKey())) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                count += str.length();
            }
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(countCharacters2(new String[]{"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin", "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb", "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl", "boygirdlggnh", "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx", "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop", "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx", "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr", "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo", "oxgaskztzroxuntiwlfyufddl", "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp", "qnagrpfzlyrouolqquytwnwnsqnmuzphne", "eeilfdaookieawrrbvtnqfzcricvhpiv", "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz", "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue", "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv", "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo", "teyygdmmyadppuopvqdodaczob", "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs", "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"},
                "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp"));
    }
}
