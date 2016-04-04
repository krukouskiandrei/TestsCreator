package by.krukouski.testscreator.command;

import by.krukouski.testscreator.logic.CreateQuestionLogic;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Question;
import by.krukouski.testscreator.subject.Test;

/**
 * Created by Krukouski Andrei on 18.03.2016.
 */
public class AddNewQuestionCommand implements IActionCommand {//add new question in Test
    private static final String PARAM_VALUE_QUESTION = "value_question";
    private static final String PARAM_CORRECT_ANSWER = "correct";
    private  static final String PARAM_ANSWER = "answer";
    private static final String PARAM_CHANGE_TEST = "changeTest";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        String valueQuestion = request.getRequstParameters(PARAM_VALUE_QUESTION)[0];
        String[] correctAnswer = request.getRequstParameters(PARAM_CORRECT_ANSWER);
        String[] answers  = request.getRequstParameters(PARAM_ANSWER);
        Question question = CreateQuestionLogic.createQuestion(valueQuestion, correctAnswer, answers);
        Test changeTest = (Test) request.getSessionAttributes(PARAM_CHANGE_TEST);
        question.setId(valueQuestion.hashCode() / 13);
        changeTest.setQuestion(question);
        request.setRequestAttributes("changeTest", changeTest);
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
