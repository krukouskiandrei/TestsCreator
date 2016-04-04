package by.krukouski.testscreator.command;


import by.krukouski.testscreator.logic.ShowTestLogic;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Test;
import org.apache.log4j.Logger;

/**
 * Created by Krukouski Andrei on 31.12.2015.
 */
public class ShowTestCommand implements IActionCommand {//show test

    static Logger logger = Logger.getLogger(ShowTestCommand.class);

    private static final String PARAM_TEST = "idtest";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        String idString = request.getRequstParameters(PARAM_TEST)[0];
        try {
            Integer id = new Integer(idString);
            Test test = ShowTestLogic.showAllTest(id);
            ConfigurationManager configurationManager = new ConfigurationManager();
            if(test != null){
                request.setRequestAttributes("test", test);
                page = configurationManager.getProperty("path.page.showTest");
            }else {
                MessageManager messageManager = new MessageManager();
                request.setRequestAttributes("errorShowTestMessage",
                        messageManager.getProperty("message.showtest"));
                page = configurationManager.getProperty("path.page.takeTest");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return page;
    }

}
