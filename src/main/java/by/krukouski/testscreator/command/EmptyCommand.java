package by.krukouski.testscreator.command;

import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.session.SessionRequestContent;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class EmptyCommand implements IActionCommand {

    @Override
    public String execute(SessionRequestContent request){
        //if will be error or direct access to controller will redirecte on login-password page
        ConfigurationManager configurationManager = new ConfigurationManager();
        String page = configurationManager.getProperty("path.page.login");
        return page;
    }

}
