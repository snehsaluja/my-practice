package com.practice.mypractice.programs.designpattern.strategy;

public class MessagingProcessor {

    Messenger messengerStrategy;

    MessagingProcessor(Messenger messengerStrategy) {
        this.messengerStrategy = messengerStrategy;
    }

    public void sendMessage(String message) {
        messengerStrategy.sendMessage(message);
    }

}
