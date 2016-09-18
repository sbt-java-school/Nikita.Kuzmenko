package ru.sbt.lessons.lesson13;

/**
 * Created by user on 15.09.2016.
 */
public class AccountMain {
    public static void main(String[] args){

        final Account acct = new Account();
        for (int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    acct.whithDrawal(2);
                }
            }).start();
        }
        System.out.println(acct.getBalans());
    }
}
