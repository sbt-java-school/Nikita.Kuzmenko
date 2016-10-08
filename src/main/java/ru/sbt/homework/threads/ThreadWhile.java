package ru.sbt.homework.threads;

/**
 * Created by Admin on 07.10.2016.
 */
public class ThreadWhile implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("Я implements Runnable");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
