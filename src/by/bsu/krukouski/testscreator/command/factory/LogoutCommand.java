package by.bsu.krukouski.testscreator.command.factory;

import by.bsu.krukouski.testscreator.command.IActionCommand;
import by.bsu.krukouski.testscreator.session.SessionRequestContent;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class LogoutCommand implements IActionCommand {//команда выхода из системы и уничтожения ссесия
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        return page;
    }
}
