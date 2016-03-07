package by.bsu.krukouski.testscreator.command;

import by.bsu.krukouski.testscreator.resource.ConfigurationManager;
import by.bsu.krukouski.testscreator.session.SessionRequestContent;

/**
 * Created by Krukouski Andrei on 31.12.2015.
 */
public class RegistrationCommand implements IActionCommand{

    @Override
    public String execute(SessionRequestContent request){
        String page = null;

        page = ConfigurationManager.getProperty("path.page.registration");

        return page;
    }

}
