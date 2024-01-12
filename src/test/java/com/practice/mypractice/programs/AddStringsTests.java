package com.practice.mypractice.programs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddStringsTests {

    AddStrings playWithStrings;

    AddStringsTests() {
        playWithStrings = new AddStrings();
    }

    @Test
    void shouldTestStringSum() {
        Assertions.assertEquals("134", playWithStrings.addStrings("11", "123"));
        Assertions.assertEquals("533", playWithStrings.addStrings("456", "77"));
        Assertions.assertEquals("100", playWithStrings.addStrings("1", "99"));
        Assertions.assertEquals("0", playWithStrings.addStrings("0", "0"));
        Assertions.assertEquals("1111111111111111111111111111111111111120",
                playWithStrings.addStrings("1111111111111111111111111111111111111111", "9"));
        Assertions.assertEquals("10000000000000000000000000000000000000000",
                playWithStrings.addStrings("9999999999999999999999999999999999999999", "1"));
        Assertions.assertEquals("1121", playWithStrings.addStrings("1111", "10"));
        Assertions.assertEquals("100", playWithStrings.addStrings("50", "50"));
        Assertions.assertEquals("101", playWithStrings.addStrings("2", "99"));
        Assertions.assertEquals("198", playWithStrings.addStrings("99", "99"));
        Assertions.assertEquals("198", playWithStrings.addStrings("99", "99"));
    }

}
