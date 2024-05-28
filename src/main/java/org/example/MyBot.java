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
        return "vk1.a.jfS58BZuvMc69j1wSnZHcG9LJDQ86GdrcFf90mNVRemTNEmqEAXxfqmK5a3uoNWIG3ktB2rSjcsABOqNvIlupV4GsTyevo3ZJRKynFcmVB79hUY7Y159wJ2bclxXuD3yRbLTr6zTLQKbUZqpcQ7N8Aqb7TsD1d3b4Sje37d6p4zRJLJDntDEoEsRo6LaySf4bKSJ3IE9boZepTQBzfpohA";
    }

    @Override
    public int getGroupId() {
        return 226065566;
    }

    public static void main(String[] args) throws BotsLongPollException {
        new BotsLongPoll(new MyBot()).run();
    }
}

