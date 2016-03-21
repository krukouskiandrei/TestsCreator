package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.UserDAO;
import by.krukouski.testscreator.exception.UserDAOException;
import by.krukouski.testscreator.subject.User;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krukouski Andrei on 15.03.2016.
 */
public class ShowUserLogic {
    static Logger logger = Logger.getLogger(ShowUserLogic.class);
    public List<User> showAllUsers(){
        UserDAO userDAO = new UserDAO();
        List<User> users = new ArrayList<>();
        try{
            users = userDAO.findAll();
        }catch (UserDAOException e){
            logger.error(e.getMessage());
        }
        userDAO.close();
        return users;
    }

}
