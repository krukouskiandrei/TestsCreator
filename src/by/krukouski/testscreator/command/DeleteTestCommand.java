package by.krukouski.testscreator.command;

import by.krukouski.testscreator.logic.DeleteTestLogic;
import by.krukouski.testscreator.session.SessionRequestContent;

/**
 * Created by Krukouski Andrei on 16.03.2016.
 */
public class DeleteTestCommand implements IActionCommand {
    private static final String PARAM_ID_TEST = "idtest";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        Integer idTest = new Integer(request.getRequstParameters(PARAM_ID_TEST)[0]);
        if(idTest != 1){
            DeleteTestLogic deleteTestLogic = new DeleteTestLogic();
            deleteTestLogic.deleteTest(idTest);
        }
        ChangeTestCommand changeTestCommand = new ChangeTestCommand();
        page = changeTestCommand.execute(request);
        return page;
    }

}
