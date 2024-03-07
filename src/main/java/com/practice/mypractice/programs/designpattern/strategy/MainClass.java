package com.practice.mypractice.programs.designpattern.strategy;

public class MainClass {
    public static void main(String[] args) {
        MessagingService messagingService = new MessagingService();
        messagingService.sendMessage("Hello", MessengerType.WHATSAPP);
        messagingService.sendMessage("Hello", MessengerType.SMS);
    }
}
