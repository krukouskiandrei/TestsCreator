package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.TestDAO;
import by.krukouski.testscreator.subject.Test;

/**
 * Created by Krukouski Andrei on 18.03.2016.
 */
public class SaveTestLogic {

    public static void updateTest(Test test){
        TestDAO testDAO = new TestDAO();
        testDAO.update(test);
        testDAO.close();
    }

}
