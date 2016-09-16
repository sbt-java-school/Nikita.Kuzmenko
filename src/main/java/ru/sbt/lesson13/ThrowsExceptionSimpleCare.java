package ru.sbt.lesson13;

/**
 * Created by user on 15.09.2016.
 */
public class ThrowsExceptionSimpleCare implements Runnable{
    @Override
    public void run() {
        throw new RuntimeException("Fufu");
    }
}
