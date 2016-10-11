package ru.sbt.homework.chat;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by Admin on 01.10.2016.
 */
public class Client {
    public static final String DEFAULT_HOST = "localhost";
    public static final int PORT = 8085;
    private static final Logger logger = Logger.getLogger(Client.class);


    public static void main(String[] args) {
        String name;
        //Чтение из консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;

        try (Socket socket = new Socket(DEFAULT_HOST, PORT)) {

            String lineStr = "";

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.print("Введите ваше имя: ");
            name = reader.readLine();


            bufferedWriter.write(name + "\n");
            bufferedWriter.flush();

            while (!lineStr.equals("exit")) {
                System.out.println("Введите отправителя, затем знак >> и введите текст: ");
                lineStr = reader.readLine();
                if (lineStr.equals("getMessage")) {
                    bufferedWriter.write(lineStr + "\n");
                    bufferedWriter.flush();
                    while (!lineStr.equals("endMessage")) {
                        lineStr = bufferedReader.readLine();
                        logger.info(lineStr);
                    }
                }
                bufferedWriter.write(lineStr + "\n");
                bufferedWriter.flush();

            }
        } catch (Exception e) {
            logger.error(e);
        }
    }
}