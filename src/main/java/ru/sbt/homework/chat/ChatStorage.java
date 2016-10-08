package ru.sbt.homework.chat;

import java.util.List;

/**
 * Хранение сообщений.
 */
public interface ChatStorage {
    void put();
    List<Message> get();
}
