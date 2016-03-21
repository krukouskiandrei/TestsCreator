package by.krukouski.testscreator.subject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Krukouski Andrei on 26.12.2015.
 */
public class Test extends Entity {

    private String topic;//test topic
    private String subject;//name of the object on which the test is made
    private int time;//time to complete the test (in minutes)
    private ArrayList<Question> questions;//list questions

    public Test(){
        questions = new ArrayList<>();
    }
    public Test(int id, String subject, String topic, int time, ArrayList<Question> questions){
        super(id);
        this.topic = topic;
        this.subject = subject;
        this.time = time;
        this.questions = new ArrayList<>();
        this.questions = questions;
    }
    public Test(int id, String subject, String topic, int time){
        super(id);
        this.topic = topic;
        this.subject = subject;
        this.time = time;
        this.questions = new ArrayList<>();
    }
    public Test(String subject, String topic, Integer time){
        this.topic = topic;
        this.subject = subject;
        this.time = time;
        this.questions = new ArrayList<>();
    }
    public boolean deleteQuestion(Integer idQuestion){
        Iterator<Question> iterator = questions.iterator();
        while (iterator.hasNext()){
            Question question = iterator.next();
            if(question.getId().equals(idQuestion)){
                questions.remove(question);
                return true;
            }
        }
        return false;
    }
    public Question getQuestion(Integer idQuestion) throws NullPointerException{
        Iterator<Question> iterator = questions.iterator();
        while (iterator.hasNext()){
            Question question = iterator.next();
            if(question.getId().equals(idQuestion)){
                return question;
            }
        }
        throw new NullPointerException("no question");
    }
    public String getTopic(){
        return topic;
    }
    public String getSubject(){
        return subject;
    }
    public int getTime(){
        return time;
    }
    public ArrayList<Question> getQuestions(){
        return questions;
    }
    public void setTopic(String topic){
        this.topic = topic;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }
    public void setTime(int time){
        this.time = time;
    }
    public void setQuestions(ArrayList<Question> questions){
        this.questions = questions;
    }
    public void setQuestion(Question question){
        this.questions.add(question);
    }
    public Integer getCountQuestions(){
        return questions.toArray().length;
    }
    @Override
    public String toString(){
        return "Test [ id = " + getId() + ", topic = " + topic + ", subject = " +
                subject + ", time = " + time + " ]";
    }
    @Override
    public int hashCode(){
        return (int)(17*getId() + time/13 + ((topic == null) ? 0 : topic.hashCode()));
    }
    @Override
    public boolean equals(Object object){
        if(this == object)
            return true;
        if(object == null)
            return false;
        if(getClass() != object.getClass())
            return false;

        Test other = (Test) object;
        if(super.getId() != other.getId())
            return false;
        if(topic == null){
            if(other.topic != null)
                return false;
        }else if(!topic.equals(other.topic))
            return false;
        if(subject == null){
            if(other.subject != null)
                return false;
        }else if(subject.equals(other.subject))
            return false;
        if(time != other.time)
            return false;
        if(!questions.equals(other.questions))
            return false;
        return true;
    }

}
