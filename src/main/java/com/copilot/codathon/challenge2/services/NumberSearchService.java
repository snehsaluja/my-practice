package com.copilot.codathon.challenge2.services;

import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class NumberSearchService {

    private final int[] predefinedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public boolean searchNumber(int number) {
        return Arrays.stream(predefinedArray).anyMatch(n -> n == number);
    }
}