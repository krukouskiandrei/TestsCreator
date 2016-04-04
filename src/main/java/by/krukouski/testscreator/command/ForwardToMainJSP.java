package by.krukouski.testscreator.command;

import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.User;

/**
 * Created by Krukouski Andrei on 03.01.2016.
 */
public class ForwardToMainJSP implements IActionCommand {//forward on main jsp
    private  static final String PARAM_USER = "user";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        User user = (User) request.getSessionAttributes(PARAM_USER);
        ConfigurationManager configurationManager = new ConfigurationManager();
        if(user != null){
            if(user.getAdmin()){
                page = configurationManager.getProperty("path.page.mainAdmin");
            }else {
                page = configurationManager.getProperty("path.page.main");
            }
        }else {
            page = configurationManager.getProperty("path.page.login");
        }
        return page;
    }

}
