package com.practice.mypractice.programs.designpattern.strategy;

public class MessagingService {


    // Strategy
    public void sendMessage(String message, MessengerType type) {

        if (type == MessengerType.SMS) {
            // this below code is strategy design pattern.
            MessagingProcessor messagingProcessor = new MessagingProcessor(new SMS());
            messagingProcessor.sendMessage(message);
        } else if (type == MessengerType.WHATSAPP) {
            MessagingProcessor messagingProcessor = new MessagingProcessor(new WhatsApp());
            messagingProcessor.sendMessage(message );
        }
    }


    // Factory
    public Messenger getMessengerObject(String message, MessengerType type) {
        Messenger messenger = null;
        if (type == MessengerType.SMS) {
            messenger = new SMS();

        } else if (type == MessengerType.WHATSAPP) {
            messenger = new WhatsApp();
        }
        return messenger;
    }
}
