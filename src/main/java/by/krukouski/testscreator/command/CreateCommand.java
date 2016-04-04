package by.krukouski.testscreator.command;

import by.krukouski.testscreator.logic.CreateLogic;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Test;
import org.apache.log4j.Logger;

/**
 * Created by Krukouski Andrei on 02.01.2016.
 */
public class CreateCommand implements IActionCommand {//create test

    private static final String PARAM_TOPIC_TEST = "topic";
    private static final String PARAM_SUBJECT_TEST = "subject";
    private static final String PARAM_TIME_TEST = "time";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        String topic = request.getRequstParameters(PARAM_TOPIC_TEST)[0];
        String subject = request.getRequstParameters(PARAM_SUBJECT_TEST)[0];
        Integer time = new Integer(request.getRequstParameters(PARAM_TIME_TEST)[0]);
            Test test = CreateLogic.createNewTest(topic, subject, time);
        ConfigurationManager configurationManager = new ConfigurationManager();
        if(test != null){
                request.setRequestAttributes("newtest", test);
                page = configurationManager.getProperty("path.page.create");
            }else {
                MessageManager messageManager = new MessageManager();
                request.setRequestAttributes("errorCreateTestMessage",
                        messageManager.getProperty("message.create"));
                page = configurationManager.getProperty("path.page.createTest");
            }
        return page;
    }

}
