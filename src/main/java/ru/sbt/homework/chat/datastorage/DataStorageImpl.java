package ru.sbt.homework.chat.datastorage;

import ru.sbt.homework.chat.messages.Message;

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
    public List<Message> getMessage(String recipient) {
        return multipleMap.get(recipient);
    }
}
