package ru.sbt.homework.gadalka;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Random;

/**
 * Created by Admin on 01.10.2016.
 */
public class ChatConnection implements Runnable {
    private final Socket socket;
    private OutputStream outputStream;
    private InputStream inputStream;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private int number;

    private static final Logger logger = Logger.getLogger(ChatConnection.class);

    public ChatConnection(Socket socket) {
        this.socket = socket;
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            number = new Random().nextInt(100);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            logger.info(Thread.currentThread().getName() + ", стартовал ...");
            String lineStr = null;
            String clientName = null;
            logger.info(Thread.currentThread().getName() + "я загадал: " +  number);
            clientName = bufferedReader.readLine();
            logger.info(Thread.currentThread().getName() + " - Клиент прислал нам: " + clientName);

            while ((lineStr = bufferedReader.readLine()) != null && Integer.parseInt(lineStr) != number){
                logger.info(clientName + " прислал: " + lineStr);
                bufferedWriter.write("no\n");
                bufferedWriter.flush();
            }
            bufferedWriter.write("yes\n");
            bufferedWriter.flush();
            logger.info(clientName + " угадал чило!");

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
