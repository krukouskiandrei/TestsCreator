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
public class CreateQuestionCommand implements IActionCommand {

    private static final String PARAM_VALUE_QUESTION = "value_question";
    private static final String PARAM_CORRECT_ANSWER = "correct_answer";
    private  static final String PARAM_ANSWER = "answer";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        String value_question = request.getRequstParameters(PARAM_VALUE_QUESTION)[0];
        String[] correct_answer = request.getRequstParameters(PARAM_CORRECT_ANSWER);
        String[] answers  = request.getRequstParameters(PARAM_ANSWER);
        CreateQuestionLogic createQuestionLogic = new CreateQuestionLogic();
        Question question = createQuestionLogic.createQuestion(value_question, correct_answer, answers);
        if(question != null){
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
