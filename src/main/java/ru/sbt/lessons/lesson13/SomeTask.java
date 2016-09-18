package ru.sbt.lessons.lesson13;

/**
 * Created by user on 15.09.2016.
 */
public class SomeTask implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(String.format("#%d(%s)", i, Thread.currentThread().getName()));
        }
    }
}

