package ru.sbt.homework.chat.messages;
/**
 * Created by Admin on 09.10.2016.
 */
public class ParseText {
    private String recipient;
    private String text;

    public ParseText(String str) {
        try {
            int length = str.indexOf(">>");
            this.recipient = str.substring(0, length);
            this.text = str.substring(length + 2);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при создании ParseText. ", e);
        }
    }

    public String getRecipient() {
        return recipient;
    }

    public String getText() {
        return text;
    }
}
