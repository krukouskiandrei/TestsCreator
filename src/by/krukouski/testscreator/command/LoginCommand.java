package by.krukouski.testscreator.command;

import by.krukouski.testscreator.function.CreatePasswordMD5;
import by.krukouski.testscreator.logic.LoginLogic;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.User;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class LoginCommand implements IActionCommand {//perform authentication command

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        //extracting login and password from request
        String login = request.getRequstParameters(PARAM_NAME_LOGIN)[0];
        String password = new CreatePasswordMD5().createPasswordMD5(request.getRequstParameters(PARAM_NAME_PASSWORD)[0]);
        //checking login and password
        LoginLogic loginLogic = new LoginLogic();
        User user = loginLogic.checkLogin(login, password);
        if(user != null){
            request.setRequestAttributes("userName", login);
            request.setRequestAttributes("user", user);
            //defining the way to main.jsp
            if(user.getAdmin()){
                page = ConfigurationManager.getProperty("path.page.mainAdmin");
            }else {
                page = ConfigurationManager.getProperty("path.page.main");
            }
        }else {
            request.setRequestAttributes("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }

        return page;
    }

}
