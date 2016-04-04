package by.krukouski.testscreator.command;

import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.session.SessionRequestContent;

/**
 * Created by Krukouski Andrei on 07.03.2016.
 */
public class EnterCommand implements IActionCommand {//forward on ligin page

    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        ConfigurationManager configurationManager = new ConfigurationManager();
        page = configurationManager.getProperty("path.page.login");
        return page;
    }

}