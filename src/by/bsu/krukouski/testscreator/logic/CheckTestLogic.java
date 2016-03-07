package by.bsu.krukouski.testscreator.logic;

import by.bsu.krukouski.testscreator.session.SessionRequestContent;
import by.bsu.krukouski.testscreator.subject.Answer;
import by.bsu.krukouski.testscreator.subject.Question;
import by.bsu.krukouski.testscreator.subject.Test;
import by.bsu.krukouski.testscreator.subject.User;

import java.util.List;

/**
 * Created by Krukouski Andrei on 01.01.2016.
 */
public class CheckTestLogic {

    public Integer checkTest(SessionRequestContent request){
        Integer result = 0;
        Test test = (Test) request.getSessionAttributes("test");
        List<Question> listQuestions = test.getQuestions();
        for (Integer i = 1; i <= test.getCountQuestions(); i++){
            Question question = listQuestions.get(i-1);
            String[] answers = request.getRequstParameters(i.toString());
            if(checkQuestion(question, answers)){
                result++;
            }
        }
        return result;
    }

    private boolean checkQuestion(Question question, String[] answers){

        if(answers == null)
            return false;
        Answer[] ans = question.getAnswers().toArray(new Answer[question.getAnswers().size()]);
        int flac = 0;
        for(int i = 0; i < answers.length; i++){
            Integer index = new Integer(answers[i]);
            if(ans[index-1].getCorrectAnswer() == false){
                return false;
            }
            if(ans[index-1].getCorrectAnswer() == true){
                flac++;
            }
        }
        if(flac != question.getCountCorrectAnswer())
            return false;
        return true;
    }

}
