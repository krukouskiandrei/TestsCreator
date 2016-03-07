package by.bsu.krukouski.testscreator.command;

import by.bsu.krukouski.testscreator.session.SessionRequestContent;

/**
 * Created by Krukouski Andrei on 25.12.2015.
 */
public interface IActionCommand {

    String execute(SessionRequestContent request);

}
