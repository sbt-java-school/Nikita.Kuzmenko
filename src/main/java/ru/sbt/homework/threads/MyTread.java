package ru.sbt.homework.threads;

/**
 * Created by Admin on 07.10.2016.
 */
public class MyTread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
