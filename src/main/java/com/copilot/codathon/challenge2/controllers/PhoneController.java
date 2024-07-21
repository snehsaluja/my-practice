package com.copilot.codathon.challenge2.controllers;

import com.copilot.codathon.challenge2.services.PhoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/validate")
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping("/phone-number")
    public ResponseEntity<String> validatePhoneNumber(@RequestBody String phoneNumber) {
        return phoneService.validatePhoneNumber(phoneNumber)
                ? ResponseEntity.ok("Phone number is in Indian format.")
                : ResponseEntity.badRequest().body("Phone number is not in Indian format.");
    }
}