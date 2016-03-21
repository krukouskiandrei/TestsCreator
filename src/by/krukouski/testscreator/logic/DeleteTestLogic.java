package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.TestDAO;

/**
 * Created by Krukouski Andrei on 16.03.2016.
 */
public class DeleteTestLogic {

    public void deleteTest(Integer id){
        TestDAO testDAO = new TestDAO();
        testDAO.delete(id);
        testDAO.close();
    }

    public void deleteQuestions(Integer idTest){
        TestDAO testDAO = new TestDAO();
        testDAO.deleteQuestionsByTestId(idTest);
        testDAO.close();
    }

}
