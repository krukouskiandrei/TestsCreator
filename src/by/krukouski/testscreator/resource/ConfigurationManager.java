package by.krukouski.testscreator.resource;

import java.util.ResourceBundle;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class ConfigurationManager {
    // class extract information with file config.properties
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.config");

    private ConfigurationManager() { }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
