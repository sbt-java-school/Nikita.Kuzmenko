package ru.sbt.homework.home18.home18_02.datastorage;

import ru.sbt.homework.home18.home18_02.messages.Message;

import java.util.List;

/**
 * Интерфейс для работы с хранилищем данных
 */
public interface DataStorage {
    void put(String recipient, Message message);
    void remove(String recipient);
    List<Message> getMessage(String recipient);
}
