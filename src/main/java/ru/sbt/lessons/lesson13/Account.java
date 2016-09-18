package ru.sbt.lessons.lesson13;

/**
 * Created by user on 15.09.2016.
 */
public class Account {
    private int balans = 50;

    public int getBalans(){return balans;}

    public void whithDrawal(int amount){
        balans = balans - amount;
    }

}
