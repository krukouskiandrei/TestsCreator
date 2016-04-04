package by.krukouski.testscreator.resource;

import java.util.ResourceBundle;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class ConfigurationManager {
    // class extract information with file config.properties
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    public ConfigurationManager() { }

    public String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
