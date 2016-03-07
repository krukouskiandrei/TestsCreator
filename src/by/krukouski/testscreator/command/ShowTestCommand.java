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
public class ShowTestCommand implements IActionCommand {

    static Logger logger = Logger.getLogger(ShowTestCommand.class);

    private static final String PARAM_TEST = "idtest";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        String id_String = request.getRequstParameters(PARAM_TEST)[0];
        try {
            Integer id = new Integer(id_String);
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
