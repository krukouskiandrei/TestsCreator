package by.krukouski.testscreator.command;

import by.krukouski.testscreator.logic.CreateAllTestLogic;
import by.krukouski.testscreator.logic.DeleteTestLogic;
import by.krukouski.testscreator.logic.SaveTestLogic;
import by.krukouski.testscreator.session.SessionRequestContent;
import by.krukouski.testscreator.subject.Test;

/**
 * Created by Krukouski Andrei on 18.03.2016.
 */
public class SaveTestCommand implements IActionCommand {//save test after changing
    private static final String PARAM_CHANGE_TEST = "changeTest";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        Test changeTest = (Test) request.getSessionAttributes(PARAM_CHANGE_TEST);
        if(changeTest.getId() != 1){
            SaveTestLogic.updateTest(changeTest);
        }

        ChangeTestCommand changeTestCommand = new ChangeTestCommand();
        page = changeTestCommand.execute(request);

        return page;
    }

}
