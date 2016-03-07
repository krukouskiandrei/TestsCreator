package by.krukouski.testscreator.command;

import by.krukouski.testscreator.command.IActionCommand;
import by.krukouski.testscreator.session.SessionRequestContent;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class LogoutCommand implements IActionCommand {//exit from system and removing session
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        return page;
    }
}
