package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.TestDAO;
import by.krukouski.testscreator.subject.Test;

/**
 * Created by Krukouski Andrei on 02.01.2016.
 */
public class CreateAllTestLogic extends Thread {
    private Test test;
    private Integer id_user;
    public CreateAllTestLogic(Test test, Integer id_user){
        this.test = test;
        this.id_user = id_user;
    }
    @Override
    public void run(){
        TestDAO testDAO = new TestDAO();
        testDAO.createTest(this.test, this.id_user);
        testDAO.close();
    }


}
