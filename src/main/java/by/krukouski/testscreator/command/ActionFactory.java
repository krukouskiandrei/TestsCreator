package by.krukouski.testscreator.command;

import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class ActionFactory {

    private static final String PARAM_NAME_COMMAND = "command";
    public IActionCommand defineCommand(SessionRequestContent request){

        IActionCommand current = new EmptyCommand();
        //extract command name from request
        String action = request.getRequstParameters(PARAM_NAME_COMMAND)[0];
        if(action == null || action.isEmpty()){
            //if command is not exist in current request
            return current;
        }
        //get object for command
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        }catch (IllegalArgumentException e){
            MessageManager messageManager = new MessageManager();
            request.setRequestAttributes("wrongAction", action + messageManager.getProperty("message.wrongaction"));
        }
        return current;

    }

}
