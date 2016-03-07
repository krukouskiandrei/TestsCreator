package by.bsu.krukouski.testscreator.logic;

import by.bsu.krukouski.testscreator.bd.UserDAO;
import by.bsu.krukouski.testscreator.subject.User;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class LoginLogic {
    //проверка имени пользователя и пароля
    public synchronized static User checkLogin(String enterLogin, String enterPassword){

        UserDAO userDAO = new UserDAO();
        User user = userDAO.findUserByLogin(enterLogin);
        userDAO.close();
        if(user.getId() == null){
            return null;
        }
        if(!user.getPassword().equals(enterPassword)){
            return null;
        }
        return user;
    }

}
