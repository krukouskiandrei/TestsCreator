package by.krukouski.testscreator.dao;

import java.util.ResourceBundle;

/**
 * Created by Krukouski Andrei on 07.03.2016.
 */
//SettingDB Class
public class SettingDB {

    private static final SettingDB instance = new SettingDB();

    public final String DB_USER_NAME;
    public final String DB_PASSWORD;
    public final String DB_URL;
    public final String DB_DRIVER;
    public final Integer DB_MAX_CONNECTIONS;

    private SettingDB(){
        ResourceBundle resource = ResourceBundle.getBundle("database");
        DB_USER_NAME = resource.getString("db.user");
        DB_PASSWORD = resource.getString("db.password");
        DB_URL = resource.getString("db.url");
        DB_DRIVER = resource.getString("db.driver");
        DB_MAX_CONNECTIONS = Integer.valueOf(resource.getString("db.poolsize"));
    }

    public static SettingDB getInstance(){
        return instance;
    }




}
