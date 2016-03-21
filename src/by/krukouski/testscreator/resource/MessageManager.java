package by.krukouski.testscreator.resource;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class MessageManager {//show messages for system
    // class extract information with file messages.properties
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.messages", Locale.getDefault());

    private MessageManager() { }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
