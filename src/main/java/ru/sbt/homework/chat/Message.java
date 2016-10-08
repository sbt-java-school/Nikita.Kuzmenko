package ru.sbt.homework.chat;

import java.util.List;

/**
 * Created by Admin on 01.10.2016.
 */
public interface Message {
    String getText();

    List<Object> getContent();

    String getAddressee();
}
