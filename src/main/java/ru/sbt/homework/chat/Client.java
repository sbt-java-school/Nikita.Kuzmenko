package ru.sbt.homework.chat;

import java.io.*;
import java.net.Socket;

/**
 * Created by Admin on 01.10.2016.
 */
public class Client {
    public static final String DEFAULT_HOST = "localhost";
    public static final int PORT = 1234;


    public static void main(String[] args) throws IOException{
        try(Socket socket = new Socket(DEFAULT_HOST, PORT)){
//            byte[] buffer = new byte[100];
            System.out.println("Connected ...");
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            //int readBytes = inputStream.read(buffer);
            //String dateString  = new String(buffer, 0, readBytes);
            //OutputStream out = socket.getOutputStream();
            for (int i = 0; i < 10; i++) {

                writer.write("Ghbdtn\n");
                writer.flush();
            }
//            bufferedReader.readLine();
            Thread.sleep(2000);

            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //System.out.println(bufferedReader.readLine());
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
