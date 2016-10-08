package ru.sbt.lessons.lesson16;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Admin on 01.10.2016.
 */
public class Client {
    public static final String DEFAULT_HOST = "localhost";
    public static final int PORT = 1234;


    public static void main(String[] args) throws IOException{
        try(Socket socket = new Socket(DEFAULT_HOST, PORT)){
            byte[] buffer = new byte[100];
            System.out.println("Connected");
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            int readBytes = inputStream.read(buffer);
            String dateString  = new String(buffer, 0, readBytes);
            //OutputStream out = socket.getOutputStream();
            dataOutputStream.writeUTF("Ghbdtn");


            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //System.out.println(bufferedReader.readLine());
        }
    }
}
