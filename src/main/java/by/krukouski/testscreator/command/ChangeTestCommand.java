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
        ConfigurationManager configurationManager = new ConfigurationManager();
        if(user != null){
            MessageManager messageManager = new MessageManager();
            if(user.getAdmin()){
                List<Test> listTests = TakeTestLogic.showAllTests();
                if(listTests.isEmpty() != true){
                    request.setRequestAttributes("changeTests", listTests);
                    page = configurationManager.getProperty("path.page.changeTest");
                }else {
                    request.setRequestAttributes("errorchangeTestsMessage",
                            messageManager.getProperty("message.changetesterror"));
                    page = configurationManager.getProperty("path.page.changeTest");
                }
            }else {
                List<Test> listTests = TakeTestLogic.findTestByUser(user.getId());
                if(listTests.isEmpty() != true){
                    request.setRequestAttributes("changeTests", listTests);
                    page = configurationManager.getProperty("path.page.changeTest");
                }else {
                    request.setRequestAttributes("errorchangeTestsMessage",
                            messageManager.getProperty("message.changetesterror"));
                    page = configurationManager.getProperty("path.page.changeTest");
                }
            }
        }else {
            page = configurationManager.getProperty("path.page.login");
        }
        return page;
    }

}
