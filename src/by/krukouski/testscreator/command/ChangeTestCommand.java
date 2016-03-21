package by.krukouski.testscreator.command;

import by.krukouski.testscreator.logic.TakeTestLogic;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Test;
import by.krukouski.testscreator.subject.User;

import java.util.List;

/**
 * Created by Krukouski Andrei on 15.03.2016.
 */
public class ChangeTestCommand implements IActionCommand {//show list tests for change
    private  static final String PARAM_USER = "user";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        User user = (User) request.getSessionAttributes(PARAM_USER);
        TakeTestLogic takeTestLogic = new TakeTestLogic();
        if(user != null){
            if(user.getAdmin()){
                List<Test> listTests = takeTestLogic.showAllTests();
                if(listTests.isEmpty() != true){
                    request.setRequestAttributes("changeTests", listTests);
                    page = ConfigurationManager.getProperty("path.page.changeTest");
                }else {
                    request.setRequestAttributes("errorchangeTestsMessage",
                            MessageManager.getProperty("message.changetesterror"));
                    page = ConfigurationManager.getProperty("path.page.changeTest");
                }
            }else {
                List<Test> listTests = takeTestLogic.findTestByUser(user.getId());
                if(listTests.isEmpty() != true){
                    request.setRequestAttributes("changeTests", listTests);
                    page = ConfigurationManager.getProperty("path.page.changeTest");
                }else {
                    request.setRequestAttributes("errorchangeTestsMessage",
                            MessageManager.getProperty("message.changetesterror"));
                    page = ConfigurationManager.getProperty("path.page.changeTest");
                }
            }
        }else {
            page = ConfigurationManager.getProperty("path.page.login");
        }



        return page;
    }

}
