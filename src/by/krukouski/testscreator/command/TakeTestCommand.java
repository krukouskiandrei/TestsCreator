package by.krukouski.testscreator.command;

import by.krukouski.testscreator.logic.TakeTestLogic;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Test;

import java.util.List;

/**
 * Created by Krukouski Andrei on 31.12.2015.
 */
public class TakeTestCommand implements IActionCommand {

    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        List<Test> listTests = TakeTestLogic.showAllTests();
        if(listTests != null){
            request.setRequestAttributes("listTests", listTests);
            page = ConfigurationManager.getProperty("path.page.takeTest");
        }else {
            request.setRequestAttributes("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }

}