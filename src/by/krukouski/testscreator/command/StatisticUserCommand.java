package by.krukouski.testscreator.command;

import by.krukouski.testscreator.logic.StatisticUserLogic;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Statistic;
import by.krukouski.testscreator.subject.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Krukouski Andrei on 14.03.2016.
 */
public class StatisticUserCommand implements IActionCommand {
    private static final String PARAM_USER = "user";
    private static final String PARAM_SATATISTIC_USER = "iduser";
    private static final String PARAM_LIST_USERS = "listUsers";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        StatisticUserLogic statisticUserLogic = new StatisticUserLogic();
        User user = (User) request.getSessionAttributes(PARAM_USER);
        List<Statistic> statistics = new ArrayList<>();
        if(user.getAdmin() != true) {
            statistics = statisticUserLogic.showAllStatistic(user.getId());
        }else {
            Integer id = new Integer(request.getRequstParameters(PARAM_SATATISTIC_USER)[0]);
            statistics = statisticUserLogic.showAllStatistic(id);
            ArrayList<User> listUsers = (ArrayList) request.getSessionAttributes(PARAM_LIST_USERS);
            Iterator<User> iterator = listUsers.iterator();
            while (iterator.hasNext()){
                User currentUser = iterator.next();
                if(currentUser.getId().equals(id)){
                    request.setRequestAttributes("currentUser", currentUser);
                    break;
                }
            }

        }
        if(statistics!=null){
            request.setRequestAttributes("statisticUser", statistics);
            page = ConfigurationManager.getProperty("path.page.statistic");
        }else {
            request.setRequestAttributes("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }

}
