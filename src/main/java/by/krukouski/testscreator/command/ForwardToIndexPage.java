package by.krukouski.testscreator.command;

import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.session.SessionRequestContent;

/**
 * Created by Krukouski Andrei on 14.03.2016.
 */
public class ForwardToIndexPage implements IActionCommand {//forward on index page
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        ConfigurationManager configurationManager = new ConfigurationManager();
        page = configurationManager.getProperty("path.page.index");
        return page;
    }
}
