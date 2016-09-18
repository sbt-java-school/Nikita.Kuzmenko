package ru.sbt.lessons.lesson14;

/**
 * Created by Admin on 17.09.2016.
 */
public class HardWork implements Runnable
{
    private Object look;

    public HardWork(Object look){
        this.look = look;
    }

    @Override
    public void run()
    {
        synchronized (look){
            try
            {
                look.wait();
            }
            catch (InterruptedException e)
            {
                //e.printStackTrace();
                return;
            }
            System.out.println("Hack!");
        }
    }
}

