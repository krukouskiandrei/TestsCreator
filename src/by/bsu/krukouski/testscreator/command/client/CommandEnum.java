package by.bsu.krukouski.testscreator.command.client;

import by.bsu.krukouski.testscreator.command.*;
import by.bsu.krukouski.testscreator.command.factory.LogoutCommand;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public enum  CommandEnum {//перечень всех команд

    LOGIN{
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT{
        {
            this.command = new LogoutCommand();
        }
    },
    REGISTRATION{
        {
            this.command = new RegistrationCommand();
        }
    },
    CREATETEST{
        {
            this.command = new CreateTestCommand();
        }
    },
    TAKETEST{
        {
            this.command = new TakeTestCommand();
        }
    },
    SHOWTEST{
        {
            this.command = new ShowTestCommand();
        }
    },
    CHECKTEST{
        {
            this.command = new CheckTestCommand();
        }
    },
    CREATE{
        {
            this.command = new CreateCommand();
        }
    },
    CREATEQUESTION{
        {
            this.command = new CreateQuestionCommand();
        }
    },
    CREATEALLTEST{
        {
            this.command = new CreateAllTestCommand();
        }
    },
    FORWARDTOMAINJSP{
        {
            this.command = new ForwardToMainJSP();
        }
    },
    CREATEUSER{
        {
            this.command = new CreateUserCommand();
        }
    };

    IActionCommand command;
    public IActionCommand getCurrentCommand(){
        return command;
    }


}
