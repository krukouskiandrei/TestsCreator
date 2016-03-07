package by.bsu.krukouski.testscreator.command;

import by.bsu.krukouski.testscreator.exception.ResourceException;
import by.bsu.krukouski.testscreator.logic.CreateLogic;
import by.bsu.krukouski.testscreator.resource.ConfigurationManager;
import by.bsu.krukouski.testscreator.resource.MessageManager;
import by.bsu.krukouski.testscreator.session.SessionRequestContent;
import by.bsu.krukouski.testscreator.subject.Test;

/**
 * Created by Krukouski Andrei on 02.01.2016.
 */
public class CreateCommand implements IActionCommand {

    private static final String PARAM_TOPIC_TEST = "topic";
    private static final String PARAM_SUBJECT_TEST = "subject";
    private static final String PARAM_TIME_TEST = "time";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        String topic = request.getRequstParameters(PARAM_TOPIC_TEST)[0];
        String subject = request.getRequstParameters(PARAM_SUBJECT_TEST)[0];
        Integer time = new Integer(request.getRequstParameters(PARAM_TIME_TEST)[0]);
        try {
            Test test = CreateLogic.createNewTest(topic, subject, time);
            if(test != null){
                request.setRequestAttributes("newtest", test);
                page = ConfigurationManager.getProperty("path.page.create");
            }else {
                request.setRequestAttributes("errorCreateTestMessage",
                        MessageManager.getProperty("message.create"));
                page = ConfigurationManager.getProperty("path.page.createTest");
            }
        }catch (Exception e){
            new ResourceException(e);
        }


        return page;
    }

}
