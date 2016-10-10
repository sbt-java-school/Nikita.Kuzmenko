package ru.sbt.homework.chat;

import org.apache.log4j.Logger;
import ru.sbt.homework.chat.datastorage.DataStorageImpl;
import ru.sbt.homework.chat.messages.MessageImpl;

import java.io.*;
import java.net.Socket;

/**
 * Created by Admin on 09.10.2016.
 */
public class ChatConnection implements Runnable {

    private static Logger logger = Logger.getLogger(ChatConnection.class);
    private Socket socket;
    private DataStorageImpl dataStorage;

    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private int number;

    public ChatConnection(Socket clientSocket, DataStorageImpl dataStorage) {
        this.socket = clientSocket;
        this.dataStorage = dataStorage;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            dataStorage.put("test" + i, new MessageImpl(Thread.currentThread().getName(), "отправили " + i));
            logger.debug(Thread.currentThread().getName() +  " отправили " + i);
        }
        logger.debug(Thread.currentThread().getName() +  " завершил работу");
    }
}
