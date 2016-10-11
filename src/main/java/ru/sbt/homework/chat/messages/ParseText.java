package ru.sbt.homework.chat.messages;

import org.apache.log4j.Logger;

/**
 * Created by Admin on 11.10.2016.
 */
public class ParseText {
    private static final Logger logger = Logger.getLogger(ParseText.class);
    private String recipient;
    private String text;

    public ParseText(String str) throws Exception {
        try {
            int length = 0;
            length = str.indexOf(">>");
            this.recipient = str.substring(0, length);
            this.text = str.substring(length + 2);
        } catch (Exception e) {
            logger.error("Ошибка при создании ParseText. " + e.getMessage());
            //throw new Exception(e);
        }
    }

    public String getRecipient() {
        return recipient;
    }

    public String getText() {
        return text;
    }
}
