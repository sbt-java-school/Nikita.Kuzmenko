package ru.sbt.homework.home18.home18_01;

/**
 * Стартует/Останавливает сервер
 */
public interface ChatServer {
    void upServer(int runingPort, int shutdownPort, int count);
}
