package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.subject.Answer;
import by.krukouski.testscreator.subject.Question;

/**
 * Created by Krukouski Andrei on 02.01.2016.
 */
public class CreateQuestionLogic {

    public Question createQuestion(String value_question, String[] correct_answer, String[] answers){
        Question question = new Question();
        question.setValueQuestion(value_question);
        for(int i = 0; i < answers.length; i++){
            Answer answer = new Answer(answers[i]);
            question.setAnswer(answer);
        }
        for(int i = 0; i < correct_answer.length; i++){
            Answer answer = new Answer(correct_answer[i], true);
            question.setAnswer(answer);
        }

        return question;
    }

}
