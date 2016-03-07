package by.bsu.krukouski.testscreator.command;

import by.bsu.krukouski.testscreator.logic.CheckTestLogic;
import by.bsu.krukouski.testscreator.resource.ConfigurationManager;
import by.bsu.krukouski.testscreator.session.SessionRequestContent;

/**
 * Created by Krukouski Andrei on 01.01.2016.
 */
public class CheckTestCommand implements IActionCommand {//проверка теста

    @Override
    public String execute(SessionRequestContent request){
        String page = null;

        CheckTestLogic checkTest = new CheckTestLogic();
        Integer result = checkTest.checkTest(request);
        request.setRequestAttributes("resultCheckTest", result);
        page = ConfigurationManager.getProperty("path.page.resultTest");
        return page;
    }

}
