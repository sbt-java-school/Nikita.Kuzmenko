package ru.sbt.homework.chat;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;

/**
 * Created by Admin on 01.10.2016.
 */
public class Client {
    public static final String DEFAULT_HOST = "localhost";
    public static final int PORT = 1234;
    private static final Logger logger = Logger.getLogger(Client.class);


    public static void main(String[] args) throws IOException{
        try(Socket socket = new Socket(DEFAULT_HOST, PORT)){
//            byte[] buffer = new byte[100];
//            System.out.println("Connected ...");
            String lineStr = null;
            int number = 0;
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
//            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            //int readBytes = inputStream.read(buffer);
            //String dateString  = new String(buffer, 0, readBytes);
            //OutputStream out = socket.getOutputStream();
            Thread.currentThread().setName("Client");
            bufferedWriter.write(Thread.currentThread().getName()  + "\n");
            bufferedWriter.flush();
            bufferedWriter.write(number + "\n");
            bufferedWriter.flush();
            while ((lineStr = bufferedReader.readLine()) != null && lineStr.equals("no")){
                Thread.sleep(1000);
                bufferedWriter.write(number  + "\n");
                bufferedWriter.flush();
                logger.info("Я думаю это: " + number);
                number++;
            }
            logger.info("Ураааааааа ... Я угадал");
//            bufferedReader.readLine();

            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //System.out.println(bufferedReader.readLine());
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
