package ru.sbt.homework.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

/**
 * Created by Admin on 01.10.2016.
 */
public class Client implements Runnable {
    public static final String DEFAULT_HOST = "localhost";
    public static final int PORT = 1234;
    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    @Override
    public void run() {
        try (Socket socket = new Socket(DEFAULT_HOST, PORT)) {

            String lineStr = null;
            int number = 0;

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            bufferedWriter.write(Thread.currentThread().getName() + "\n");
            bufferedWriter.flush();

            bufferedWriter.write(number + "\n");
            bufferedWriter.flush();
            while ((lineStr = bufferedReader.readLine()) != null && lineStr.equals("no")) {
                number++;
                Thread.sleep(500);
                bufferedWriter.write(number + "\n");
                bufferedWriter.flush();
                logger.info("Я думаю это: " + number);
            }
            logger.info("Ураааааааа ... Я угадал");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
