package ru.sbt.homework.chat;

import org.apache.log4j.Logger;
import ru.sbt.homework.chat.datastorage.DataStorageImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 09.10.2016.
 */
public class Server {
    private static Logger logger = Logger.getLogger(ru.sbt.homework.gadalka.Server.class);
    public static final int SERVER_PORT = 8085;
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(4, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));
    private static DataStorageImpl dataStorage = new DataStorageImpl();

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            while (true) {
                logger.debug("Слушаем порт: " + SERVER_PORT);
                Socket clientSocket = serverSocket.accept();
                THREAD_POOL_EXECUTOR.execute(new ChatConnection(clientSocket, dataStorage));
                logger.info("Перенаправили сокет в новый поток ...");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
