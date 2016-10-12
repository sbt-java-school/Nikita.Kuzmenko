package ru.sbt.homework.home18.home18_02;

import org.apache.log4j.Logger;
import ru.sbt.homework.home18.home18_02.datastorage.DataStorageImpl;
import ru.sbt.homework.home18.home18_02.messages.ParseText;
import ru.sbt.homework.home18.home18_02.messages.Message;
import ru.sbt.homework.home18.home18_02.messages.MessageImpl;

import java.io.*;
import java.net.Socket;

/**
 * Сервер для приема и передачи данных по указанному сокету
 */
public class ChatConnection implements Runnable {

    private static Logger logger = Logger.getLogger(ChatConnection.class);
    private Socket socket;
    private DataStorageImpl dataStorage;

    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientName;
    private String lineStr;

    private ParseText parseText;

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
        try {
            bufferedWriter.write("Введите ваше имя: \n");
            bufferedWriter.flush();
            clientName = bufferedReader.readLine();
            logger.info("Клиент " + clientName + " присоединился ...");
            while ((lineStr = bufferedReader.readLine()) != null && !lineStr.equals("exit")) {
                if (lineStr.equals("getMessage")) {
                    logger.info("Клиент " + clientName + " просит выслать ему все сообщения...");
                    for (Message message : dataStorage.getMessage(clientName)) {
                        bufferedWriter.write(message.getSender() + " >> " + message.getText() + "\n");
                        bufferedWriter.flush();
                    }
                    bufferedWriter.write("endMessage\n");
                    bufferedWriter.flush();
                    dataStorage.remove(clientName);
                } else {
                    parseText = new ParseText(lineStr, "<<");
                    dataStorage.put(parseText.getRecipient(), new MessageImpl(clientName, parseText.getText()));
                }
            }
            logger.info("Клиент " + clientName + " закрыл соединение ...");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
