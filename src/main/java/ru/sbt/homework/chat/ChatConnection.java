package ru.sbt.homework.chat;

import org.apache.log4j.Logger;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;

/**
 * Created by Admin on 01.10.2016.
 */
public class ChatConnection implements Runnable {
    private final Socket socket;
    private OutputStream outputStream;
    private InputStream inputStream;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    private static final Logger logger = Logger.getLogger(ChatConnection.class);

    public ChatConnection(Socket socket) {
        this.socket = socket;
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            logger.info(Thread.currentThread().getName() + ", Погнали ...");
            String lineStr = null;
            //Выполняем цикл, пока поток не прерван
            while (!Thread.currentThread().isInterrupted()) {
                lineStr = bufferedReader.readLine();
                //logger.info(lineStr);
                System.out.println(lineStr);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            // throw new RuntimeException(e);
        }

    }
}
