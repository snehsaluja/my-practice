package com.copilot.codathon.challenge1.models;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Data
    public static class Geo {
        private String lat;
        private String lng;
    }
}