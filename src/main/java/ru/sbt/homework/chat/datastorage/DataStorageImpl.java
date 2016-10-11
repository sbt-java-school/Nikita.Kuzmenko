package ru.sbt.homework.chat.datastorage;

import ru.sbt.homework.chat.messages.Message;

import java.util.Collections;
import java.util.List;

/**
 * Created by Admin on 08.10.2016.
 */
public class DataStorageImpl implements DataStorage {
    private MultipleMap<String, Message> multipleMap = new MultipleMapImpl<>();

    @Override
    public void put(String recipient, Message message) {
        multipleMap.put(recipient, message);
    }

    @Override
    public void remove(String recipient) {
        multipleMap.del(recipient);
    }

    @Override
    public List<Message> getMessage(String recipient) {
        List<Message> messages = multipleMap.get(recipient);
        return messages == null ? Collections.emptyList() : messages;
    }
}
