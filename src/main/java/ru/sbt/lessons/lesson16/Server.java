package ru.sbt.lessons.lesson16;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 01.10.2016.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        byte[] buffer = new byte[100];

        try(ServerSocket serverSocket = new ServerSocket(1234)) {
            while(true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    OutputStream out = clientSocket.getOutputStream();
                    InputStream inputStream = clientSocket.getInputStream();

                    String dateString = dateFormat.format(new Date());
                    out.write(dateString.getBytes());

                    int readBytes = inputStream.read(buffer);
                    String dateS  = new String(buffer, 0, readBytes);
                    System.out.println("it's Work " + dateS);
                }
            }
        }
    }
}
