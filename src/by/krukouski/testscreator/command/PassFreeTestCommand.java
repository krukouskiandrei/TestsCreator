package by.krukouski.testscreator.command;

import by.krukouski.testscreator.logic.ShowTestLogic;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Test;
import org.apache.log4j.Logger;

/**
 * Created by Krukouski Andrei on 07.03.2016.
 */
public class PassFreeTestCommand implements IActionCommand {

    static Logger logger = Logger.getLogger(PassFreeTestCommand.class);

    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        try {
            Integer id = 1;
            ShowTestLogic showTestLogic = new ShowTestLogic();
            Test test = showTestLogic.showAllTest(id);
            if(test != null){
                request.setRequestAttributes("test", test);
                page = ConfigurationManager.getProperty("path.page.showTest");
            }else {
                request.setRequestAttributes("errorShowTestMessage",
                        MessageManager.getProperty("message.showtest"));
                page = ConfigurationManager.getProperty("path.page.takeTest");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return page;
    }

}