package by.krukouski.testscreator.command;

import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.User;

/**
 * Created by Krukouski Andrei on 03.01.2016.
 */
public class ForwardToMainJSP implements IActionCommand {
    private  static final String PARAM_USER = "user";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        User user = (User) request.getSessionAttributes(PARAM_USER);
        if(user != null){
            page = ConfigurationManager.getProperty("path.page.main");
        }else {
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }

}
