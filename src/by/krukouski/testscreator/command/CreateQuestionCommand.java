package by.krukouski.testscreator.command;

import by.krukouski.testscreator.logic.CreateQuestionLogic;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Question;
import by.krukouski.testscreator.subject.Test;

/**
 * Created by Krukouski Andrei on 02.01.2016.
 */
public class CreateQuestionCommand implements IActionCommand {//create Question

    private static final String PARAM_VALUE_QUESTION = "value_question";
    private static final String PARAM_CORRECT_ANSWER = "correct";
    private  static final String PARAM_ANSWER = "answer";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        String valueQuestion = request.getRequstParameters(PARAM_VALUE_QUESTION)[0];
        String[] correctAnswer = request.getRequstParameters(PARAM_CORRECT_ANSWER);
        String[] answers  = request.getRequstParameters(PARAM_ANSWER);
        CreateQuestionLogic createQuestionLogic = new CreateQuestionLogic();
        Question question = createQuestionLogic.createQuestion(valueQuestion, correctAnswer, answers);
        if(question.getValueQuestion() != null){
            Test test = (Test) request.getSessionAttributes("newtest");
            test.setQuestion(question);
            request.setRequestAttributes("newtest", test);
            page = ConfigurationManager.getProperty("path.page.create");
        }else {
            request.setRequestAttributes("errorCreateQuestion",
                    MessageManager.getProperty("message.createQuestion"));
            page = ConfigurationManager.getProperty("path.page.createTest");
        }

        return page;
    }

}
