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
public class CreateCommand implements IActionCommand {

    static Logger logger = Logger.getLogger(CreateCommand.class);

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
            CreateLogic createLogic = new CreateLogic();
            Test test = createLogic.createNewTest(topic, subject, time);
            if(test != null){
                request.setRequestAttributes("newtest", test);
                page = ConfigurationManager.getProperty("path.page.create");
            }else {
                request.setRequestAttributes("errorCreateTestMessage",
                        MessageManager.getProperty("message.create"));
                page = ConfigurationManager.getProperty("path.page.createTest");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }


        return page;
    }

}
