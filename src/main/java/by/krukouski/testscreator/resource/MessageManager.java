package by.krukouski.testscreator.resource;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class MessageManager {//show messages for system
    // class extract information with file messages.properties
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", Locale.getDefault());

    public MessageManager() { }

    public String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
