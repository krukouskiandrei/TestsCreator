package by.krukouski.testscreator.command;

import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.session.SessionRequestContent;

/**
 * Created by Krukouski Andrei on 31.12.2015.
 */
public class RegistrationCommand implements IActionCommand{//forward on registration page

    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        ConfigurationManager configurationManager = new ConfigurationManager();
        page = configurationManager.getProperty("path.page.registration");

        return page;
    }

}
