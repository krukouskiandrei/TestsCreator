package by.krukouski.testscreator.command;

import by.krukouski.testscreator.logic.ShowUserLogic;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.User;

import java.util.List;

/**
 * Created by Krukouski Andrei on 15.03.2016.
 */
public class ShowUserCommand implements IActionCommand {//show users

    public String execute(SessionRequestContent request){
        String page = null;
        List<User> users = ShowUserLogic.showAllUsers();
        ConfigurationManager configurationManager = new ConfigurationManager();
        if(!users.isEmpty()){
            request.setRequestAttributes("listUsers", users);
            page = configurationManager.getProperty("path.page.showUser");
        }else {
            MessageManager messageManager = new MessageManager();
            request.setRequestAttributes("errorshowUsersMessage",
                    messageManager.getProperty("message.showusererror"));
            page = configurationManager.getProperty("path.page.showUser");
        }
        return page;
    }

}
