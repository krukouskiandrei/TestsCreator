package by.bsu.krukouski.testscreator.command;

import by.bsu.krukouski.testscreator.logic.CreateAllTestLogic;
import by.bsu.krukouski.testscreator.logic.CreateQuestionLogic;
import by.bsu.krukouski.testscreator.resource.ConfigurationManager;
import by.bsu.krukouski.testscreator.session.SessionRequestContent;
import by.bsu.krukouski.testscreator.subject.Question;
import by.bsu.krukouski.testscreator.subject.Test;
import by.bsu.krukouski.testscreator.subject.User;

/**
 * Created by Krukouski Andrei on 02.01.2016.
 */
public class CreateAllTestCommand implements IActionCommand {//создание теста
    private static final String PARAM_NEW_TEST = "newtest";
    private static final String PARAM_VALUE_QUESTION = "value_question";
    private static final String PARAM_CORRECT_ANSWER = "correct_answer";
    private  static final String PARAM_ANSWER = "answer";
    private static final String PARAM_USER = "user";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        String value_question = request.getRequstParameters(PARAM_VALUE_QUESTION)[0];
        String[] correct_answer = request.getRequstParameters(PARAM_CORRECT_ANSWER);
        String[] answers  = request.getRequstParameters(PARAM_ANSWER);
        Question question = CreateQuestionLogic.createQuestion(value_question, correct_answer, answers);
        Test test = (Test) request.getSessionAttributes(PARAM_NEW_TEST);
        User user = (User) request.getSessionAttributes(PARAM_USER);
        test.setQuestion(question);
        CreateAllTestLogic createAllTestLogic = new CreateAllTestLogic(test, user.getId());
        createAllTestLogic.start();
        page = ConfigurationManager.getProperty("path.page.testCreated");

        return page;
    }

}
