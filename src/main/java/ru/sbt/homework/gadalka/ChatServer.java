package ru.sbt.homework.gadalka;

/**
 * Стартует/Останавливает сервер
 */
public interface ChatServer {
    void upServer(int runingPort, int shutdownPort, int count);
}
