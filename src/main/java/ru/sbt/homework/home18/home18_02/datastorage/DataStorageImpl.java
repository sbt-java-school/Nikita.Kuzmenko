package ru.sbt.homework.home18.home18_02.datastorage;

import ru.sbt.homework.home18.home18_02.messages.Message;

import java.util.Collections;
import java.util.List;

/**
 * Класс работает с хранилищем данных (в данном случает только с мультимапой)
 */
public class DataStorageImpl implements DataStorage {
    private MultipleMap<String, Message> multipleMap = new MultipleMapImpl<>();

    @Override
    public void put(String recipient, Message message) {
        if(recipient != null && message != null) {
            multipleMap.put(recipient, message);
        }
    }

    @Override
    public void remove(String recipient) {
        multipleMap.del(recipient);
    }

    @Override
    public void clear() {
        multipleMap.delAll();
    }

    @Override
    public List<Message> getMessage(String recipient) {
        List<Message> messages = multipleMap.get(recipient);
        return messages == null ? Collections.emptyList() : messages;
    }
}
