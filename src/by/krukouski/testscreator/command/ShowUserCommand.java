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
public class ShowUserCommand implements IActionCommand {

    public String execute(SessionRequestContent request){
        String page = null;
        ShowUserLogic showUserLogic = new ShowUserLogic();
        List<User> users = showUserLogic.showAllUsers();
        if(users.isEmpty() != true){
            request.setRequestAttributes("listUsers", users);
            page = ConfigurationManager.getProperty("path.page.showUser");
        }else {
            request.setRequestAttributes("errorshowUsersMessage",
                    MessageManager.getProperty("message.showusererror"));
            page = ConfigurationManager.getProperty("path.page.showUser");
        }
        return page;
    }

}
