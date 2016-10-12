package ru.sbt.homework.home18.home18_01;

import ru.sbt.homework.home18.home18_02.messages.Message;

/**
 * Created by Admin on 01.10.2016.
 */
public class TextMessage implements Message {
    private final String text;

    public TextMessage(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getSender() {
        return null;
    }
}
