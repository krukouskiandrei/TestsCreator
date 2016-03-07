package by.krukouski.testscreator.subject;

/**
 * Created by Krukouski Andrei on 26.12.2015.
 */
public class Statistic {

    private int takeTests;
    private int rightTests;

    public Statistic(){}
    public Statistic(int takeTests, int rightTests){
        this.rightTests = rightTests;
        this.takeTests = takeTests;
    }
    public int getTakeTests(){
        return takeTests;
    }
    public int getRightTests(){
        return rightTests;
    }
    public void setTakeTests(int takeTests){
        this.takeTests = takeTests;
    }
    public void setRightTests(int rightTests){
        this.rightTests = rightTests;
    }
    public void addTakeTests(){
        takeTests++;
    }
    public void addRighTasts(){
        rightTests++;
    }

}
