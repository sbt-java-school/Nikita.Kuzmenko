package ru.sbt.homework.chat;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 01.10.2016.
 */
public class Server {
    private final int nThreads;
    private final ChatConnection[] threads;
    private static Logger logger = Logger.getLogger(Server.class);
    private static final int SERVER_PORT = 1234;

    public Server(int nThreads, ChatConnection[] threads) {
        this.nThreads = nThreads;
        this.threads = threads;
    }

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            logger.info("Listen on " + SERVER_PORT);
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    Thread thread = new Thread(new ChatConnection(clientSocket));
                    thread.start();
                    logger.info("Перенаправили сокет в новый поток с именем" + thread.getName());
                }
            }
        }
    }
}
