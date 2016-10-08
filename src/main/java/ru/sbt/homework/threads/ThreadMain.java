package ru.sbt.homework.threads;

import org.apache.log4j.Logger;

/**
 * Created by Admin on 07.10.2016.
 */
public class ThreadMain {
    public static void main(String[] args) throws RuntimeException {
        Thread threadWhile = new Thread(new ThreadWhile());
        threadWhile.start();
        for (int i = 0; i < 20; i++) {
            Thread thread = new MyTread();
            thread.start();
        }
    }
}
