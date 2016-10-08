package ru.sbt.homework.chat;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 01.10.2016.
 */
public class Server {
    private final int nThreads;
    private final ChatConnection[] threads;
    private static Logger logger = Logger.getLogger(Server.class);
    private static final int SERVER_PORT = 1234;
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(4, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));


    public Server(int nThreads, ChatConnection[] threads) {
        this.nThreads = nThreads;
        this.threads = threads;
    }

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            while (true) {
                logger.info("Слушаем порт " + SERVER_PORT);
                Socket clientSocket = serverSocket.accept();
//                Thread thread = new Thread(new ChatConnection(clientSocket));
//                thread.start();
                THREAD_POOL_EXECUTOR.execute(new ChatConnection(clientSocket));
                logger.info("Перенаправили сокет в новый поток ...");
            }
        }
    }
}

