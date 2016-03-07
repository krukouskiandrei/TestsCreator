package by.bsu.krukouski.testscreator.command;

import by.bsu.krukouski.testscreator.logic.TakeTestLogic;
import by.bsu.krukouski.testscreator.resource.ConfigurationManager;
import by.bsu.krukouski.testscreator.resource.MessageManager;
import by.bsu.krukouski.testscreator.session.SessionRequestContent;
import by.bsu.krukouski.testscreator.subject.Test;

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
