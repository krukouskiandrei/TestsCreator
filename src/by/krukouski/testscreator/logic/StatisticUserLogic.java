package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.dao.UserDAO;
import by.krukouski.testscreator.subject.Statistic;

import java.util.List;

/**
 * Created by Krukouski Andrei on 14.03.2016.
 */
public class StatisticUserLogic {

    public List<Statistic> showAllStatistic(Integer idUser){
        UserDAO userDAO = new UserDAO();
        List<Statistic> statistics = userDAO.findUserStatistics(idUser);
        userDAO.close();
        return statistics;
    }

}
