package ru.sbt.homework.home18.home18_02.messages;

import org.apache.log4j.Logger;

/**
 * Created by Admin on 09.10.2016.
 */
public class ParseText {
    private String recipient;
    private String text;

    private static Logger logger = Logger.getLogger(ParseText.class);

    public ParseText(String str, String parser) {
        try {
            int length = str.indexOf(parser);
            this.recipient = str.substring(0, length);
            this.text = str.substring(length + 2);
        } catch (Exception e) {
//            throw new RuntimeException("Ошибка при создании ParseText. ", e);
            logger.error("Ошибка при создании ParseText. ");
        }
    }

    public String getRecipient() {
        return recipient;
    }

    public String getText() {
        return text;
    }
}
