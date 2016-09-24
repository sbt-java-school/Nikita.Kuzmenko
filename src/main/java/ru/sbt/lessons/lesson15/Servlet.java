package ru.sbt.lessons.lesson15;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Admin on 24.09.2016.
 */
public class Servlet {
    AtomicInteger counter = new AtomicInteger();

    public void handle(){
        //todo: increment ...
        long current = counter.incrementAndGet();
    }
}
