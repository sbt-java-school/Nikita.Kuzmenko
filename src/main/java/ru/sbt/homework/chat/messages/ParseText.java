package ru.sbt.homework.chat.messages;

/**
 * Created by Admin on 11.10.2016.
 */
public class ParseText {
    private String recipient;
    private String text;
    private Boolean createParseText = false;

    public ParseText(String str) {
        try {
            int length = 0;
            length = str.indexOf(">>");
            this.recipient = str.substring(0, length);
            this.text = str.substring(length + 2);
            createParseText = true;
        } catch (Exception e) {
            //System.out.println("Ошибка при создании ParseText. " + e.getMessage());
        }
    }

    public String getRecipient() {
        return recipient;
    }

    public String getText() {
        return text;
    }

    /**
     * Возвращает истину, если сообщение было корректно составленно и ложь, если нет.
     */
    public Boolean checkCreateParseText(){
        return createParseText;
    }
}
