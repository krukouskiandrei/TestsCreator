package by.bsu.krukouski.testscreator.command;

import by.bsu.krukouski.testscreator.resource.ConfigurationManager;
import by.bsu.krukouski.testscreator.session.SessionRequestContent;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class EmptyCommand implements IActionCommand {

    @Override
    public String execute(SessionRequestContent request){
        //в случае ошибки или прямого обращения к контроллеру произойдет переадрусация на страницу ввода логина и пароля
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }

}
