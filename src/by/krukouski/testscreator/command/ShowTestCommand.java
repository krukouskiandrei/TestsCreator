package by.krukouski.testscreator.command;

import by.krukouski.testscreator.exception.ResourceException;
import by.krukouski.testscreator.logic.ShowTestLogic;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Test;

/**
 * Created by Krukouski Andrei on 31.12.2015.
 */
public class ShowTestCommand implements IActionCommand {
    private static final String PARAM_TEST = "idtest";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        String id_String = request.getRequstParameters(PARAM_TEST)[0];
        try {
            Integer id = new Integer(id_String);
            Test test = ShowTestLogic.showAllTest(id);
            if(test != null){
                request.setRequestAttributes("test", test);
                page = ConfigurationManager.getProperty("path.page.showTest");
            }else {
                request.setRequestAttributes("errorShowTestMessage",
                        MessageManager.getProperty("message.showtest"));
                page = ConfigurationManager.getProperty("path.page.takeTest");
            }
        }catch (Exception e){
            new ResourceException(e);
        }

        return page;
    }

}
