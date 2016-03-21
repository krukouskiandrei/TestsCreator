package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.UserDAO;

/**
 * Created by Krukouski Andrei on 18.03.2016.
 */
public class DeleteUserLogic {

    public void deleteUser(Integer id){
        UserDAO userDAO = new UserDAO();
        userDAO.delete(id);
        userDAO.close();
    }

}
