package com.copilot.codathon.challenge2.services;

import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    public boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("[789][0-9]{9}");
    }
}