package by.krukouski.testscreator.command;

import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.session.SessionRequestContent;

/**
 * Created by Krukouski Andrei on 18.03.2016.
 */
public class ChangeNameTestCommand implements IActionCommand {

    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        page = ConfigurationManager.getProperty("path.page.changeNameTest");
        return page;
    }

}
