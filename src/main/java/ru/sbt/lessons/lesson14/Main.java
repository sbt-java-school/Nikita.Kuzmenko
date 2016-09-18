package ru.sbt.lessons.lesson14;
//Потокобезопасная обертка коллекции

/**
 * Created by Admin on 17.09.2016.
 */
public class Main{
    public static void main(String[] args) throws InterruptedException{
        TestEnd threadEnd = new TestEnd();
        new Thread(threadEnd).start();
        Thread.sleep(2000);
        threadEnd.end();
        System.out.println("URA");
    }
}
