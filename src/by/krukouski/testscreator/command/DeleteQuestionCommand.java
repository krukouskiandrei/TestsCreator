package by.krukouski.testscreator.command;

import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Test;

/**
 * Created by Krukouski Andrei on 17.03.2016.
 */
public class DeleteQuestionCommand implements IActionCommand {//delete question from test

    private static final String PARAM_CHANGE_TEST = "changeTest";
    private static final String PARAM_DELETE_QUESTION_ID = "idquestion";

    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        Integer idQuestion = new Integer(request.getRequstParameters(PARAM_DELETE_QUESTION_ID)[0]);
        Test changeTest = (Test) request.getSessionAttributes(PARAM_CHANGE_TEST);
        changeTest.deleteQuestion(idQuestion);
        request.setRequestAttributes("changeTest", changeTest);
        if(changeTest.getQuestions().isEmpty() != true){
            page = ConfigurationManager.getProperty("path.page.showListQuestions");
        }else {
            request.setRequestAttributes("errorShowChangeQuestionsMessage",
                    MessageManager.getProperty("message.showchangequestions"));
            page = ConfigurationManager.getProperty("path.page.showListQuestions");
        }
        return page;
    }
}
