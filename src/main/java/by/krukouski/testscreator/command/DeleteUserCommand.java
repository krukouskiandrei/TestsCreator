package by.krukouski.testscreator.command;

import by.krukouski.testscreator.logic.DeleteTestLogic;
import by.krukouski.testscreator.logic.DeleteUserLogic;
import by.krukouski.testscreator.session.SessionRequestContent;

/**
 * Created by Krukouski Andrei on 18.03.2016.
 */
public class DeleteUserCommand implements IActionCommand {//delete usual user
    private static final String PARAM_ID_USER = "iduser";
    @Override
    public String execute(SessionRequestContent request){
        String page = null;
        Integer idUser = new Integer(request.getRequstParameters(PARAM_ID_USER)[0]);
        DeleteUserLogic.deleteUser(idUser);

       ShowUserCommand showUserCommand = new ShowUserCommand();
        page = showUserCommand.execute(request);
        return page;
    }

}
