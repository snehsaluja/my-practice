package com.practice.mypractice.programs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringFunTests {

    LongestPalindromeSubstring playWithStrings;

    StringFunTests() {
        playWithStrings = new LongestPalindromeSubstring();
    }

    @Test
    void shouldTestPalindrome() {
        Assertions.assertEquals("noon", playWithStrings.getLongestPalindromeSubstring("noon"));
        Assertions.assertEquals("mom", playWithStrings.getLongestPalindromeSubstring("mom"));
        Assertions.assertEquals("geeksskeeg", playWithStrings.getLongestPalindromeSubstring("forgeeksskeegfor"));
        Assertions.assertEquals("radar", playWithStrings.getLongestPalindromeSubstring("eradar"));
        Assertions.assertEquals("radar", playWithStrings.getLongestPalindromeSubstring("pqwdradarsse"));
        Assertions.assertEquals("monom", playWithStrings.getLongestPalindromeSubstring("monomsnem"));
    }

    @Test
    void shouldTestPalindromeWithSpaces() {
        Assertions.assertEquals(" mom ", playWithStrings.getLongestPalindromeSubstring("noos mom hi noon"));
        Assertions.assertEquals("mom", playWithStrings.getLongestPalindromeSubstring("mom loves momos"));
        Assertions.assertEquals("mom mom mom", playWithStrings.getLongestPalindromeSubstring("mom mom mom"));
        Assertions.assertEquals("geeksskeeg", playWithStrings.getLongestPalindromeSubstring("forgeeksskeeg for"));
        Assertions.assertEquals("radar", playWithStrings.getLongestPalindromeSubstring("e radar"));
        Assertions.assertEquals(" radar ", playWithStrings.getLongestPalindromeSubstring("pqwd radar sse"));
        Assertions.assertEquals("monom", playWithStrings.getLongestPalindromeSubstring("monom snem"));
        Assertions.assertEquals(" deified ", playWithStrings.getLongestPalindromeSubstring("hello mom civic tata tatat deified "));
    }

    @Test
    void shouldTestPalindromeSentence() {
        Assertions.assertEquals("deified",
                playWithStrings.getLongestPalindromeWordFromAString("hello mom civic tata tatat deified"));
        Assertions.assertEquals("mom", playWithStrings.getLongestPalindromeWordFromAString("mom loves momos"));
        Assertions.assertEquals("mom", playWithStrings.getLongestPalindromeWordFromAString("mom mom mom"));
        Assertions.assertEquals("geeksskeeg", playWithStrings.getLongestPalindromeWordFromAString("forgeeksskeeg for"));
        Assertions.assertEquals("radar", playWithStrings.getLongestPalindromeWordFromAString("e radar"));
        Assertions.assertEquals("radar", playWithStrings.getLongestPalindromeWordFromAString("pqwd radar sse"));
        Assertions.assertEquals("monom", playWithStrings.getLongestPalindromeWordFromAString("monom snem"));
    }
}
