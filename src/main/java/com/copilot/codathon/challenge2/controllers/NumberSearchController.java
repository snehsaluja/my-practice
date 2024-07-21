package com.copilot.codathon.challenge2.controllers;

import com.copilot.codathon.challenge2.services.NumberSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/number-search")
public class NumberSearchController {

    private final NumberSearchService numberSearchService;

    public NumberSearchController(NumberSearchService numberSearchService) {
        this.numberSearchService = numberSearchService;
    }

    @GetMapping
    public ResponseEntity<Boolean> searchNumber(@RequestParam int number) {
        boolean isFound = numberSearchService.searchNumber(number);
        return ResponseEntity.ok(isFound);
    }
}