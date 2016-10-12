package ru.sbt.homework.home18.home18_01;

import ru.sbt.homework.home18.home18_02.messages.Message;

import java.util.List;

/**
 * Хранение сообщений.
 */
public interface ChatStorage {
    void put();
    List<Message> get();
}
