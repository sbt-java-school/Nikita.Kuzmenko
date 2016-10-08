package ru.sbt.homework.chat;

/**
 * Стартует/Останавливает сервер
 */
public interface ChatServer {
    void upServer(int runingPort, int shutdownPort, int count);
}
