package by.krukouski.testscreator.command;

import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Test;

/**
 * Created by Krukouski Andrei on 18.03.2016.
 */
public class ChangeNameCommand implements IActionCommand {//change topic, subject and time in test
    private static final String PARAM_TOPIC_TEST = "topic";
    private static final String PARAM_SUBJECT_TEST = "subject";
    private static final String PARAM_TIME_TEST = "time";
    private static final String PARAM_CHANGE_TEST = "changeTest";

    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        String topic = request.getRequstParameters(PARAM_TOPIC_TEST)[0];
        String subject = request.getRequstParameters(PARAM_SUBJECT_TEST)[0];
        Integer time = new Integer(request.getRequstParameters(PARAM_TIME_TEST)[0]);
        Test changeTest = (Test) request.getSessionAttributes(PARAM_CHANGE_TEST);
        changeTest.setSubject(subject);
        changeTest.setTopic(topic);
        changeTest.setTime(time);
        ConfigurationManager configurationManager = new ConfigurationManager();
        if(changeTest.getQuestions().isEmpty() != true){
            page = configurationManager.getProperty("path.page.showListQuestions");
        }else {
            MessageManager messageManager = new MessageManager();
            request.setRequestAttributes("errorShowChangeQuestionsMessage",
                    messageManager.getProperty("message.showchangequestions"));
            page = configurationManager.getProperty("path.page.showListQuestions");
        }
        return page;
    }

}
