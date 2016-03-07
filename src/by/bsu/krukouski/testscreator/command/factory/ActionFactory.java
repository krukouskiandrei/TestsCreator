package by.bsu.krukouski.testscreator.command.factory;

import by.bsu.krukouski.testscreator.command.EmptyCommand;
import by.bsu.krukouski.testscreator.command.IActionCommand;
import by.bsu.krukouski.testscreator.command.client.CommandEnum;
import by.bsu.krukouski.testscreator.resource.MessageManager;
import by.bsu.krukouski.testscreator.session.SessionRequestContent;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class ActionFactory {

    private static final String PARAM_NAME_COMMAND = "command";
    public IActionCommand defineCommand(SessionRequestContent request){

        IActionCommand current = new EmptyCommand();
        //извелечение названия команды из запроса
        String action = request.getRequstParameters(PARAM_NAME_COMMAND)[0];
        if(action == null || action.isEmpty()){
            //если команды нет в текущем запросе
            return current;
        }
        //получение объекта, соответствующего команде
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        }catch (IllegalArgumentException e){
            request.setRequestAttributes("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
        }
        return current;

    }

}
