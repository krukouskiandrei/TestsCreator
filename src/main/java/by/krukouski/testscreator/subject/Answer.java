package by.krukouski.testscreator.subject;

/**
 * Created by Krukouski Andrei on 26.12.2015.
 */
public class Answer extends Entity{

    private String valueAnswer;
    private boolean correctAnswer;

    public Answer(){}
    public Answer(int id, String valueAnswer, boolean correctAnswer){
        super(id);
        this.valueAnswer = valueAnswer;
        this.correctAnswer = correctAnswer;
    }
    public Answer(String valueAnswer, boolean correctAnswer){
        this.valueAnswer = valueAnswer;
        this.correctAnswer = correctAnswer;
    }
    public Answer(String valueAnswer){
        this.valueAnswer = valueAnswer;
        this.correctAnswer = false;
    }
    public String getValueAnswer(){
        return valueAnswer;
    }
    public void setValueAnswer(String valueAnswer){
        this.valueAnswer = valueAnswer;
    }
    public void setCorrectAnswer(boolean correctAnswer){
        this.correctAnswer = correctAnswer;
    }
    public boolean getCorrectAnswer(){
        return correctAnswer;
    }
    @Override
    public String toString(){
        return "Answer [ id = " + getId() + ", valueAnswer = " + valueAnswer + ", correctAnswer = "+ correctAnswer + " ]";
    }
    @Override
    public int hashCode(){
        return (int)(23*getId() + ((valueAnswer == null) ? 0 : valueAnswer.hashCode()));
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

        Answer other = (Answer) object;
        if(!getId().equals(other.getId())){
            return false;
        }
        if(valueAnswer == null){
            if(other.valueAnswer != null){
                return false;
            }
        }else if(!valueAnswer.equals(other.valueAnswer)){
            return false;
        }
        if(correctAnswer != other.getCorrectAnswer()){
            return false;
        }
        return true;
    }

}
