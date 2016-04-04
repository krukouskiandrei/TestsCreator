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
public class TakeTestCommand implements IActionCommand {//show list tests

    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        List<Test> listTests = TakeTestLogic.showAllTests();
        ConfigurationManager configurationManager = new ConfigurationManager();
        if(!listTests.isEmpty()){
            request.setRequestAttributes("listTests", listTests);
            page = configurationManager.getProperty("path.page.takeTest");
        }else {
            MessageManager messageManager = new MessageManager();
            request.setRequestAttributes("errorLoginPassMessage",
                    messageManager.getProperty("message.loginerror"));
            page = configurationManager.getProperty("path.page.login");
        }
        return page;
    }

}
