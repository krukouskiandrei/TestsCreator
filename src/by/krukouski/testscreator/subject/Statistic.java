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


}
