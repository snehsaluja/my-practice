package com.copilot.codathon.challenge1.models;

import lombok.Data;

@Data
public class User {

    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Address address;
    private Company company;

    @Data
    public static class Company {
        private String name;
        private String catchPhrase;
        private String bs;
    }
}