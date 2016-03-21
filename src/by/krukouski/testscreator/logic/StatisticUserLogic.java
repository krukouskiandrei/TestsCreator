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
    static Logger logger = Logger.getLogger(StatisticUserLogic.class);
    public List<Statistic> showAllStatistic(Integer idUser){
        UserDAO userDAO = new UserDAO();
        List<Statistic> statistics = new ArrayList<>();
        try {
            statistics = userDAO.findUserStatistics(idUser);
        }catch (UserDAOException e){
            logger.error(e.getMessage());
        }
        userDAO.close();
        return statistics;
    }

}
