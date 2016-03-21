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
public class AddNewQuestionCommand implements IActionCommand {
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
        CreateQuestionLogic createQuestionLogic = new CreateQuestionLogic();
        Question question = createQuestionLogic.createQuestion(valueQuestion, correctAnswer, answers);
        Test changeTest = (Test) request.getSessionAttributes(PARAM_CHANGE_TEST);
        question.setId(valueQuestion.hashCode()/13);
        changeTest.setQuestion(question);
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
