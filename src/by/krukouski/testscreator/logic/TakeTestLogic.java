package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.TestDAO;
import by.krukouski.testscreator.exception.TestDAOException;
import by.krukouski.testscreator.subject.Test;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krukouski Andrei on 31.12.2015.
 */
public class TakeTestLogic {
    static Logger logger = Logger.getLogger(TakeTestLogic.class);
    public List<Test> showAllTests(){

        TestDAO testDAO = new TestDAO();
        List<Test> tests = new ArrayList<>();
        try{
            tests = testDAO.findAll();
        }catch (TestDAOException e){
            logger.error(e.getMessage());
        }
        testDAO.close();
        return tests;

    }

    public List<Test> findTestByUser(Integer idUser){
        TestDAO testDAO = new TestDAO();
        List<Test> tests = new ArrayList<>();
        try{
            tests = testDAO.findTestByUserId(idUser);
        }catch (TestDAOException e){
            logger.error(e.getMessage());
        }
        testDAO.close();
        return tests;
    }

}
