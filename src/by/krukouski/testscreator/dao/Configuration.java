package by.krukouski.testscreator.dao;

import java.util.ResourceBundle;

/**
 * Created by Krukouski Andrei on 07.03.2016.
 */
//Configuration Class
public class Configuration {

    public String DB_USER_NAME;
    public String DB_PASSWORD;
    public String DB_URL;
    public String DB_DRIVER;
    public Integer DB_MAX_CONNECTIONS;

    public Configuration(){
        init();
    }

    private static Configuration configuration = new Configuration();

    public static Configuration getInstance(){
        return configuration;
    }
    //sets the database configuration properties
    private void init(){
        ResourceBundle resource = ResourceBundle.getBundle("resources.database");
        DB_USER_NAME = resource.getString("db.user");
        DB_PASSWORD = resource.getString("db.password");
        DB_URL = resource.getString("db.url");
        DB_DRIVER = resource.getString("db.driver");
        DB_MAX_CONNECTIONS = Integer.valueOf(resource.getString("db.poolsize"));
    }

}
