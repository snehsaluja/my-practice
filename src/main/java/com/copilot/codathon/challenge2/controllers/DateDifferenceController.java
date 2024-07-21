package com.copilot.codathon.challenge2.controllers;

import com.copilot.codathon.challenge2.services.DateDifferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/date-difference")
public class DateDifferenceController {

    private final DateDifferenceService dateDifferenceService;

    public DateDifferenceController(DateDifferenceService dateDifferenceService) {
        this.dateDifferenceService = dateDifferenceService;
    }

    @GetMapping
    public ResponseEntity<Long> calculateDaysBetween(@RequestParam String startDate, @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        long daysBetween = dateDifferenceService.calculateDaysBetween(start, end);
        return ResponseEntity.ok(daysBetween);
    }
}