package by.krukouski.testscreator.command;

import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Question;
import by.krukouski.testscreator.subject.Test;
import org.apache.log4j.Logger;

/**
 * Created by Krukouski Andrei on 17.03.2016.
 */
public class ShowChangeQuestionCommand implements IActionCommand {//show question for change
    static Logger logger = Logger.getLogger(ShowChangeQuestionCommand.class);
    private static final String PARAM_CHANGE_TEST = "changeTest";
    private static final String PARAM_DELETE_QUESTION_ID = "idquestion";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        Integer idQuestion = new Integer(request.getRequstParameters(PARAM_DELETE_QUESTION_ID)[0]);
        Test changeTest = (Test) request.getSessionAttributes(PARAM_CHANGE_TEST);
        Question changeQuestion = null;
        try {
            changeQuestion = changeTest.getQuestion(idQuestion);
        }catch (NullPointerException e){
            logger.error(e.getMessage());
        }
        ConfigurationManager configurationManager = new ConfigurationManager();
        request.setRequestAttributes("changeQuestion", changeQuestion);
        page = configurationManager.getProperty("path.page.showChangeQuestion");

        return page;
    }
}
