package ru.sbt.homework.home18.home18_02.fortest;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by Admin on 01.10.2016.
 */
public class ClientForMulti implements Runnable {
    public static final String DEFAULT_HOST = "localhost";
    public static final int PORT = 8085;
    private static final Logger logger = Logger.getLogger(ClientForMulti.class);
    private String name;

    public ClientForMulti(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader;

        try (Socket socket = new Socket(DEFAULT_HOST, PORT)) {


            String lineStr = "Привет от пользователя " + name;

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            bufferedReader.readLine();

            bufferedWriter.write(name + "\n");
            bufferedWriter.flush();

            for (int i = 0; i < 10; i++) {
                bufferedWriter.write("test10<<" + lineStr + " " + i + "\n");
                bufferedWriter.flush();
            }

        } catch (Exception e) {
            logger.error(e);
        }
    }
}
