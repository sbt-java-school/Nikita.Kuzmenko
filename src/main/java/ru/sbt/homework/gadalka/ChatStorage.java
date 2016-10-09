package ru.sbt.homework.gadalka;

import ru.sbt.homework.chat.messages.Message;

import java.util.List;

/**
 * Хранение сообщений.
 */
public interface ChatStorage {
    void put();
    List<Message> get();
}
