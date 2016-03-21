package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.subject.Answer;
import by.krukouski.testscreator.subject.Question;

/**
 * Created by Krukouski Andrei on 02.01.2016.
 */
public class CreateQuestionLogic {

    public Question createQuestion(String valueQuestion, String[] correctAnswer, String[] answers){
        Question question = new Question();
        question.setValueQuestion(valueQuestion);
        int j = 0;
        Integer correct = 0;
        for (int i=0; i<answers.length; i++){
            String flac = answers[i];
            if(j<correctAnswer.length) {
                correct = new Integer(correctAnswer[j]);
            }
            if(i+1==correct){
                if(flac!=""){
                    Answer answer = new Answer(flac, true);
                    question.setAnswer(answer);
                }
                j++;
                continue;
            }
            if(flac!=""){
                Answer answer = new Answer(flac);
                question.setAnswer(answer);
            }
        }
        return question;
    }

}
