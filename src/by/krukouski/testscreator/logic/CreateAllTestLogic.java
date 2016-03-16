package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.TestDAO;
import by.krukouski.testscreator.subject.Test;

/**
 * Created by Krukouski Andrei on 02.01.2016.
 */
public class CreateAllTestLogic extends Thread {
    private Test test;
    private Integer idUser;
    public CreateAllTestLogic(Test test, Integer idUser){
        this.test = test;
        this.idUser = idUser;
    }
    @Override
    public void run(){
        TestDAO testDAO = new TestDAO();
        testDAO.createTest(this.test, this.idUser);
        testDAO.close();
    }


}
