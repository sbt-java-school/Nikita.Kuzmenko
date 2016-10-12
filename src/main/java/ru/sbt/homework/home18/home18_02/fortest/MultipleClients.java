package ru.sbt.homework.home18.home18_02.fortest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 08.10.2016.
 */
public class MultipleClients {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(new ClientForMulti("test" + i), "Client-" + i).start();
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(2000));
        }
    }
}
