package by.bsu.krukouski.testscreator.logic;

import by.bsu.krukouski.testscreator.bd.TestDAO;
import by.bsu.krukouski.testscreator.subject.Question;
import by.bsu.krukouski.testscreator.subject.Test;

import java.util.List;

/**
 * Created by Krukouski Andrei on 31.12.2015.
 */
public class ShowTestLogic {

    public synchronized static Test showAllTest(Integer id){

        TestDAO testDAO = new TestDAO();
        Test test = testDAO.findEntityById(id);
        testDAO.close();
        if(test == null)
            return null;
        return test;
    }

}
