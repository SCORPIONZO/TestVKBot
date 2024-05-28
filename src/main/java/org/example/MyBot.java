package org.example;

import api.longpoll.bots.BotsLongPoll;
import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.methods.messages.MessagesSend;
import api.longpoll.bots.model.events.messages.MessageNewEvent;
import api.longpoll.bots.model.objects.basic.Message;

public class MyBot extends LongPollBot {
    @Override
    public void onMessageNew(MessageNewEvent messageNewEvent) {
        try {
            Message message = messageNewEvent.getMessage();
            if (message.hasText()) {
                String response = "Вы написали: " + message.getText();
                new MessagesSend(getAccessToken())
                        .setPeerId(message.getPeerId())
                        .setMessage(response)
                        .execute();
            }
        } catch (BotsLongPollException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getAccessToken() {
        return ""}//your Token

    @Override
    public int getGroupId() {
        return ; // your ID
    }

    public static void main(String[] args) throws BotsLongPollException {
        new BotsLongPoll(new MyBot()).run();
    }
}

