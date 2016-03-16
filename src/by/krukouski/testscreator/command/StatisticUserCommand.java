package by.krukouski.testscreator.command;

import by.krukouski.testscreator.logic.StatisticUserLogic;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Statistic;
import by.krukouski.testscreator.subject.User;

import java.util.List;

/**
 * Created by Krukouski Andrei on 14.03.2016.
 */
public class StatisticUserCommand implements IActionCommand {
    private static final String PARAM_USER = "user";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        StatisticUserLogic statisticUserLogic = new StatisticUserLogic();
        User user = (User) request.getSessionAttributes(PARAM_USER);
        List<Statistic> statistics = statisticUserLogic.showAllStatistic(user.getId());
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
