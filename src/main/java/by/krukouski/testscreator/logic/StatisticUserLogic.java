package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.UserDAO;
import by.krukouski.testscreator.exception.UserDAOException;
import by.krukouski.testscreator.subject.Statistic;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krukouski Andrei on 14.03.2016.
 */
public class StatisticUserLogic {
    public static List<Statistic> showAllStatistic(Integer idUser){
        UserDAO userDAO = new UserDAO();
        List<Statistic> statistics = new ArrayList<>();
        statistics = userDAO.findUserStatistics(idUser);
        userDAO.close();
        return statistics;
    }

}
