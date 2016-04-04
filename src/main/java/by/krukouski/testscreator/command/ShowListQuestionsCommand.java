package by.krukouski.testscreator.command;

import by.krukouski.testscreator.logic.ShowTestLogic;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Test;
import org.apache.log4j.Logger;

/**
 * Created by Krukouski Andrei on 16.03.2016.
 */
public class ShowListQuestionsCommand implements IActionCommand {//show list questions for change

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
            MessageManager messageManager = new MessageManager();
            if(test != null){
                request.setRequestAttributes("changeTest", test);
                page = configurationManager.getProperty("path.page.showListQuestions");
                if(test.getQuestions().isEmpty()){
                    request.setRequestAttributes("errorShowQuetionsMessage",
                            messageManager.getProperty("message.showchangequestions"));
                }
            }else {
                request.setRequestAttributes("errorShowTestMessage",
                        messageManager.getProperty("message.showtest"));
                page = configurationManager.getProperty("path.page.changeTest");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return page;
    }

}
