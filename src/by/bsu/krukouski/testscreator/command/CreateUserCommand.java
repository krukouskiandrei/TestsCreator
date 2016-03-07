package by.bsu.krukouski.testscreator.command;

import by.bsu.krukouski.testscreator.function.CreatePasswordMD5;
import by.bsu.krukouski.testscreator.logic.CreateUserLogic;
import by.bsu.krukouski.testscreator.resource.ConfigurationManager;
import by.bsu.krukouski.testscreator.resource.MessageManager;
import by.bsu.krukouski.testscreator.session.SessionRequestContent;
import by.bsu.krukouski.testscreator.subject.User;

/**
 * Created by Krukouski Andrei on 08.01.2016.
 */
public class CreateUserCommand implements IActionCommand {

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
        int index = new CreateUserLogic().createUser(user);
        if(index == 1){
            request.setRequestAttributes("user", user);
            //определение пути к main.jsp
            page = ConfigurationManager.getProperty("path.page.login");
        }else if (index == 0){
            request.setRequestAttributes("errorLogin",
                    MessageManager.getProperty("message.login"));
            page = ConfigurationManager.getProperty("path.page.registration");
        }else {
            request.setRequestAttributes("errorPassword",
                    MessageManager.getProperty("message.password"));
            page = ConfigurationManager.getProperty("path.page.registration");
        }

        return page;
    }

}
