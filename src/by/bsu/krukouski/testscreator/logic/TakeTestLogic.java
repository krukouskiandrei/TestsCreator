package by.bsu.krukouski.testscreator.logic;

import by.bsu.krukouski.testscreator.bd.TestDAO;
import by.bsu.krukouski.testscreator.subject.Test;

import java.util.List;

/**
 * Created by Krukouski Andrei on 31.12.2015.
 */
public class TakeTestLogic {

    public synchronized static List<Test> showAllTests(){

        TestDAO testDAO = new TestDAO();
        List<Test> tests = testDAO.findAll();
        testDAO.close();
        return tests;

    }

}
