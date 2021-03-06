package by.krukouski.testscreator.command;

import by.krukouski.testscreator.function.CreatePasswordMD5;
import by.krukouski.testscreator.logic.CreateUserLogic;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.User;

/**
 * Created by Krukouski Andrei on 08.01.2016.
 */
public class CreateUserCommand implements IActionCommand {//create user

    private static final String PARAM_NAME_FIRSTNAME = "firstname";
    private static final String PARAM_NAME_LASTNAME = "lastname";
    private static final String PARAM_NAME_EMAIL = "email";
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAN_NAME_PASSWORD = "password";

    @Override
    public String execute(SessionRequestContent request){
        String page = null;

        User user = new User();
        user.setFirstname(request.getRequstParameters(PARAM_NAME_FIRSTNAME)[0]);
        user.setLastname(request.getRequstParameters(PARAM_NAME_LASTNAME)[0]);
        user.setEmail(request.getRequstParameters(PARAM_NAME_EMAIL)[0]);
        user.setLogin(request.getRequstParameters(PARAM_NAME_LOGIN)[0]);
        user.setPassword(new CreatePasswordMD5().createPasswordMD5(request.getRequstParameters(PARAN_NAME_PASSWORD)[0]));
        int index = CreateUserLogic.createUser(user);
        ConfigurationManager configurationManager = new ConfigurationManager();
        MessageManager messageManager = new MessageManager();
        if(index == 1){
            request.setRequestAttributes("user", user);
            //defines the way to main.jsp
            page = configurationManager.getProperty("path.page.login");
        }else if (index == 0){
            request.setRequestAttributes("errorLogin",
                    messageManager.getProperty("message.login"));
            page = configurationManager.getProperty("path.page.registration");
        }else {
            request.setRequestAttributes("errorPassword",
                    messageManager.getProperty("message.password"));
            page = configurationManager.getProperty("path.page.registration");
        }

        return page;
    }

}
