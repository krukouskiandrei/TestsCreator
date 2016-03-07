package by.krukouski.testscreator.resource;

import java.util.ResourceBundle;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class ConfigurationManager {
    // класс извлекает информацию из файла config.properties
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.config");

    private ConfigurationManager() { }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
