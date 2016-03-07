package by.bsu.krukouski.testscreator.command;

import by.bsu.krukouski.testscreator.function.CreatePasswordMD5;
import by.bsu.krukouski.testscreator.logic.LoginLogic;
import by.bsu.krukouski.testscreator.resource.ConfigurationManager;
import by.bsu.krukouski.testscreator.resource.MessageManager;
import by.bsu.krukouski.testscreator.session.SessionRequestContent;
import by.bsu.krukouski.testscreator.subject.User;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class LoginCommand implements IActionCommand {//выполнение команды Авторизации

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        //извлечение логина и пороля из запроса
        String login = request.getRequstParameters(PARAM_NAME_LOGIN)[0];
        //String password = request.getRequstParameters(PARAM_NAME_PASSWORD)[0];
        String password = new CreatePasswordMD5().createPasswordMD5(request.getRequstParameters(PARAM_NAME_PASSWORD)[0]);
        //проверка логина и пароля
        User user = LoginLogic.checkLogin(login, password);
        if(user != null){
            request.setRequestAttributes("userName", login);
            request.setRequestAttributes("user", user);
            //определение пути к main.jsp
            page = ConfigurationManager.getProperty("path.page.main");
        }else {
            request.setRequestAttributes("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }

        return page;
    }

}
