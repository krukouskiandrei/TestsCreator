package by.krukouski.testscreator.subject;

/**
 * Created by Krukouski Andrei on 26.12.2015.
 */
public class Statistic {

    private String nameTest;//test name
    private Integer score;//number of points
    private String time;//passing time

    public Statistic(){}
    public Statistic(String nameTest, Integer score, String time){
        this.nameTest = nameTest;
        this.score = score;
        this.time = time;
    }
    public void setNameTest(String nameTest){
        this.nameTest = nameTest;
    }
    public void setScore(Integer score){
        this.score = score;
    }
    public void setTime(String time){
        this.time = time;
    }
    public String getNameTest(){
        return nameTest;
    }
    public Integer getScore(){
        return score;
    }
    public String getTime(){
        return time;
    }
    @Override
    public int hashCode(){
        return (int)(13*score + nameTest.hashCode());
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
        Statistic other = (Statistic) object;
        if(nameTest == null){
            if(other.nameTest != null){
                return false;
            }
        }else if(!nameTest.equals(other.nameTest)) {
            return false;
        }
        if(time == null){
            if(other.time != null){
                return false;
            }
        }else if(!time.equals(other.time)) {
            return false;
        }
        if(!score.equals(other.score)){
            return false;
        }
        return true;
    }

}
