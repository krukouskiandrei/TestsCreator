package by.bsu.krukouski.testscreator.resource;

import java.util.ResourceBundle;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class MessageManager {//вывод сообщения сиситеме
    // класс извлекает информацию из файла messages.properties
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.messages");

    private MessageManager() { }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}