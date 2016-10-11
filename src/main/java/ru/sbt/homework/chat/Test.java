package ru.sbt.homework.chat;

import ru.sbt.homework.chat.messages.ParseText;

import java.io.*;

/**
 * Created by Admin on 11.10.2016.
 */
public class Test {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ParseText parseText;
        String strLine = "";
        Integer.parseInt("три");

//        while (!strLine.equals("exit")) {
//            try {
//                System.out.println("Введите отправителя, затем знак >> и введите текст: ");
//                strLine = reader.readLine();
//
//                parseText = new ParseText(strLine);
//                if(parseText.checkCreateParseText()) {
//                    System.out.println("Получатель: " + parseText.getRecipient());
//                    System.out.println("Текст письма: " + parseText.getText());
//                }
//            } catch (IOException e) {
//                System.out.println("Ошибка ввода данных. " + e.getMessage());
//            }
//        }
    }
}
