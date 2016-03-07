package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.TestDAO;
import by.krukouski.testscreator.subject.Test;

import java.util.List;

/**
 * Created by Krukouski Andrei on 31.12.2015.
 */
public class TakeTestLogic {

    public List<Test> showAllTests(){

        TestDAO testDAO = new TestDAO();
        List<Test> tests = testDAO.findAll();
        testDAO.close();
        return tests;

    }

}
