package ru.sbt.homework.chat;

import org.apache.log4j.Logger;
import ru.sbt.homework.chat.datastorage.DataStorageImpl;
import ru.sbt.homework.chat.messages.ParseText;
import ru.sbt.homework.chat.messages.Message;
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
            clientName = bufferedReader.readLine();
            logger.info("Клиент " + clientName + " присоединился ...");
            while ((lineStr = bufferedReader.readLine()) != null && !lineStr.equals("exit")) {
                if (lineStr.equals("getMessage")) {
                    logger.info("Клиент " + clientName + " просит выслать ему все сообщения...");
                    for (Message message : dataStorage.getMessage(clientName)) {
                        bufferedWriter.write(message.getSender() + "<<" + message.getText() + "\n");
                        bufferedWriter.flush();
                    }
                    bufferedWriter.write("endMessage\n");
                    bufferedWriter.flush();
                    dataStorage.remove(clientName);
                } else {
                    parseText = new ParseText(lineStr);
                    dataStorage.put(parseText.getRecipient(), new MessageImpl(clientName, parseText.getText()));
                }
            }
            logger.info("Клиент " + clientName + " закрыл соединение ...");
        } catch (Exception e) {
//            logger.error(e.getMessage());
            e.printStackTrace();
        }

//        for (int i = 0; i < 10; i++) {
//            dataStorage.put(Thread.currentThread().getName(), new MessageImpl(Thread.currentThread().getName(), "отправили " + i));
//            logger.debug(Thread.currentThread().getName() +  " отправили " + i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                logger.error(e.getMessage());
//            }
//        }
//        logger.debug(Thread.currentThread().getName() +  " завершил работу");
    }
}
