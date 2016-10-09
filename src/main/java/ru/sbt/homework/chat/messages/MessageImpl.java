package ru.sbt.homework.chat.messages;

/**
 * Created by Admin on 09.10.2016.
 */
public class MessageImpl implements Message{
    private String text;
    private String sender;

    MessageImpl (String sender, String text){
        this.sender = sender;
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getSender() {
        return sender;
    }
}
