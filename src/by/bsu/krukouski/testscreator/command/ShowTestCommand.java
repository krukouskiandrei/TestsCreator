package by.bsu.krukouski.testscreator.command;

import by.bsu.krukouski.testscreator.exception.ResourceException;
import by.bsu.krukouski.testscreator.logic.ShowTestLogic;
import by.bsu.krukouski.testscreator.resource.ConfigurationManager;
import by.bsu.krukouski.testscreator.resource.MessageManager;
import by.bsu.krukouski.testscreator.session.SessionRequestContent;
import by.bsu.krukouski.testscreator.subject.Test;
import sun.awt.image.ShortInterleavedRaster;

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
