package ru.sbt.homework.chat.datastorage;

import ru.sbt.homework.chat.messages.Message;

import java.util.List;

/**
 * Created by Admin on 08.10.2016.
 */
public interface DataStorage {
    void put(String recipient, Message message);
    void remove(String recipient);
    List<Message> getMessage(String recipient);
}
