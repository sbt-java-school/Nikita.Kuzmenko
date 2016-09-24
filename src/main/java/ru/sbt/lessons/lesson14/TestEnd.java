package ru.sbt.lessons.lesson14;

/**
 * Created by Admin on 17.09.2016.
 */
public class TestEnd implements Runnable {
    private boolean endFlag = false;
    private Object look = new Object();

    public void end() {
        synchronized (look) {
            endFlag = true;
        }
    }

    @Override
    public void run() {
        int count = 0;
        while (!endFlag) {
            synchronized (look) {
                if (endFlag)
                    break;
            }
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }
        System.out.println("Stop");
    }
}
