package ru.sbt.lesson13;

/**
 * Created by user on 15.09.2016.
 */
public class AccountExample  implements Runnable{
    private Account acct = new Account();

    private void makeWhithdrawal (int amt) throws InterruptedException {
        if(acct.getBalans() >= amt){
            Thread.sleep(100);
            acct.whithDrawal(amt);
        }
    }

    @Override
    public void run() {
//        makeWhithdrawal(10);
        for (int x = 0; x < 15; x++){
            System.out.println("overdrawn");
        }
    }
}
