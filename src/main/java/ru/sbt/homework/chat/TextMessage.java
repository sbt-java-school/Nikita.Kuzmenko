package ru.sbt.homework.chat;

import java.util.Collections;
import java.util.List;

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
    public List<Object> getContent() {
        return Collections.emptyList();
    }

    @Override
    public String getAddressee() {
        return null;
    }
}
