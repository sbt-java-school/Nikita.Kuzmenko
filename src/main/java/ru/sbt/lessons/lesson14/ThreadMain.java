package ru.sbt.lessons.lesson14;

public class ThreadMain {
    public static void main(String[] args) throws Exception
    {
        Object look = new Object();
        for (int i = 0; i < 10; i++){
            new Thread(new HardWork(look)).start();
        }

        System.out.println("Enter to start");
        int read = System.in.read();
        System.out.println(read);
        synchronized (look){
            look.notifyAll();
            //look.notify();
        }
    }
}
