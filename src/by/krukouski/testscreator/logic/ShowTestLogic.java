package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.TestDAO;
import by.krukouski.testscreator.exception.TestDAOException;
import by.krukouski.testscreator.subject.Test;

/**
 * Created by Krukouski Andrei on 31.12.2015.
 */
public class ShowTestLogic {

    public Test showAllTest(Integer id){

        try{
            TestDAO testDAO = new TestDAO();
            Test test = testDAO.findEntityById(id);
            testDAO.close();
            return test;
        }catch (TestDAOException e){
            return null;
        }
    }

}
