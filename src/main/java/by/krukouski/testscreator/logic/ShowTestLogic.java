package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.TestDAO;
import by.krukouski.testscreator.exception.TestDAOException;
import by.krukouski.testscreator.subject.Test;

/**
 * Created by Krukouski Andrei on 31.12.2015.
 */
public class ShowTestLogic {

    public static Test showAllTest(Integer id){

        TestDAO testDAO = new TestDAO();
        Test test = testDAO.findEntityById(id);
        testDAO.close();
        if(test.getSubject() == null){
            return null;
        }
        return test;

    }

}
