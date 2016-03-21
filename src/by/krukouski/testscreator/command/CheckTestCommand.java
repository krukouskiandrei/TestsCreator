package by.krukouski.testscreator.command;

import by.krukouski.testscreator.dao.UserDAO;
import by.krukouski.testscreator.logic.CheckTestLogic;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Statistic;
import by.krukouski.testscreator.subject.Test;
import by.krukouski.testscreator.subject.User;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Krukouski Andrei on 01.01.2016.
 */
public class CheckTestCommand implements IActionCommand {//the test checking

    private static final String PARAM_USER = "user";

    @Override
    public String execute(SessionRequestContent request){
        String page = null;

        CheckTestLogic checkTest = new CheckTestLogic();
        Integer result = checkTest.checkTest(request);
        User user = (User) request.getSessionAttributes(PARAM_USER);
        if(user != null){
            Test test = (Test) request.getSessionAttributes("test");//add data to statistic table
            UserDAO userDAO = new UserDAO();
            Date d = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String data = format.format(d);
            Statistic statistic = new Statistic(test.getTopic(), result, data);
            userDAO.createStatisticTabel(user.getId(), statistic);
            userDAO.close();
        }
        request.setRequestAttributes("resultCheckTest", result);
        page = ConfigurationManager.getProperty("path.page.resultTest");
        return page;
    }

}
