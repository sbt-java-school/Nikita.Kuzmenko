package ru.sbt.lessons.lesson15;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ServletContainer {

    public static final int NUMBER_OF_THREADS = 100;
    private ScheduledExecutorService executorService;
    private Servlet servlet = new Servlet();

    private void start() {
        //executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        executorService = Executors.newScheduledThreadPool(NUMBER_OF_THREADS);
        executorService.scheduleWithFixedDelay(()-> System.out.println("tik"), 0, 1, TimeUnit.SECONDS);

    }

    public void stop(){
        try {
//            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void newUserRequest(){
        executorService.submit(servlet::handle);
    }

    public static void main(String[] args) throws InterruptedException {
        ServletContainer container = new ServletContainer();
        container.start();

        for (int i = 0; i < 1000; i++){
            container.newUserRequest();
        }
        TimeUnit.SECONDS.sleep(5);
        container.stop();
        System.out.println(container.servlet.counter);

    }
}
