package by.krukouski.testscreator.command;

import by.krukouski.testscreator.logic.CreateAllTestLogic;
import by.krukouski.testscreator.logic.CreateQuestionLogic;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Question;
import by.krukouski.testscreator.subject.Test;
import by.krukouski.testscreator.subject.User;

/**
 * Created by Krukouski Andrei on 02.01.2016.
 */
public class CreateAllTestCommand implements IActionCommand {//creating the test
    private static final String PARAM_NEW_TEST = "newtest";
    private static final String PARAM_VALUE_QUESTION = "value_question";
    private static final String PARAM_CORRECT_ANSWER = "correct";
    private  static final String PARAM_ANSWER = "answer";
    private static final String PARAM_USER = "user";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        String valueQuestion = request.getRequstParameters(PARAM_VALUE_QUESTION)[0];
        String[] correctAnswer = request.getRequstParameters(PARAM_CORRECT_ANSWER);
        String[] answers  = request.getRequstParameters(PARAM_ANSWER);
        CreateQuestionLogic createQuestionLogic = new CreateQuestionLogic();
        Question question = createQuestionLogic.createQuestion(valueQuestion, correctAnswer, answers);
        Test test = (Test) request.getSessionAttributes(PARAM_NEW_TEST);
        User user = (User) request.getSessionAttributes(PARAM_USER);
        test.setQuestion(question);
        CreateAllTestLogic createAllTestLogic = new CreateAllTestLogic(test, user.getId());
        createAllTestLogic.start();
        page = ConfigurationManager.getProperty("path.page.testCreated");

        return page;
    }

}
