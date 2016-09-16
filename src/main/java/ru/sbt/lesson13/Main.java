package ru.sbt.lesson13;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by user on 15.09.2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
//        SomeTask task = new SomeTask();
//        task.run();

//        for (int i = 0; i < 4; i++){
//            Thread t = new Thread(new SomeTask());
//
//        }
//        Thread t = new Thread(new DeamonExample());
//        t.setDaemon(true);
//        t.start();
//        Thread.sleep(1000);

        //*
        //Пперехватываем исключение
        //*
//        Thread t = new Thread(new ThrowsExceptionSimpleCare());
//        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                System.out.println("Exception " + e.getMessage());
//            }
//        });
//        t.start();
//        t.getState();

        AccountExample accountExample = new AccountExample();
        for (int i = 0; i < 10; i++){

        }
    }
}
