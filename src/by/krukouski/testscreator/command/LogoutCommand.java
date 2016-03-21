package by.krukouski.testscreator.command;

import by.krukouski.testscreator.command.IActionCommand;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.User;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class LogoutCommand implements IActionCommand {//exit from system and removing session
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        User user = null;
        request.setRequestAttributes("user", user);
        page = ConfigurationManager.getProperty("path.page.index");
        return page;
    }
}
