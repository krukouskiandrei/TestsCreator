package by.krukouski.testscreator.subject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Krukouski Andrei on 26.12.2015.
 */
public class Question extends Entity {

    private String valueQuestion;//questions
    private ArrayList<Answer> answers;//answers

    public Question(){
        answers = new ArrayList<>();
    }
    public Question(int id, String valueQuestion, ArrayList<Answer> answers){
        super(id);
        this.valueQuestion = valueQuestion;
        this.answers = new ArrayList<Answer>();
        this.answers = answers;
    }
    public Question(int id, String valueQuestion){
        super(id);
        this.valueQuestion = valueQuestion;
        this.answers = new ArrayList<Answer>();
    }
    public Question(String valueQuestion){
        this.valueQuestion = valueQuestion;
        this.answers = new ArrayList<Answer>();
    }
    public Integer getCountCorrectAnswer(){
        Integer count = 0;
        Iterator<Answer> iterator = answers.iterator();
        while (iterator.hasNext()){
            Answer answer = iterator.next();
            if(answer.getCorrectAnswer()){
                count++;
            }
        }
        return count;
    }
    public String getValueQuestion(){
        return valueQuestion;
    }
    public ArrayList<Answer> getAnswers(){
        return answers;
    }
    public void setValueQuestion(String valueQuestion){
        this.valueQuestion = valueQuestion;
    }
    public void setAnswers(ArrayList<Answer> answers){
        this.answers = answers;
    }
    public void setAnswer(Answer answer){
        this.answers.add(answer);
    }
    public Integer getCountAnswers(){
        return answers.toArray().length;
    }
    @Override
    public int hashCode(){
        return (int)(17*getId() + ((valueQuestion == null) ? 0 : valueQuestion.hashCode()));
    }
    @Override
    public String toString(){
        return "Question [ id = " + getId() + ", valueQuestion = " + valueQuestion + " ]";
    }
    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(object == null){
            return false;
        }
        if(getClass() != object.getClass()){
            return false;
        }

        Question other = (Question) object;
        if(!getId().equals(other.getId())){
            return false;
        }
        if(valueQuestion == null){
            if(other.valueQuestion != null){
                return false;
            }
        }else if (!valueQuestion.equals(other.valueQuestion)){
            return false;
        }
        if (answers.equals(other.answers)){
            return false;
        }
        return true;
    }


}
