package by.krukouski.testscreator.command;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public enum  CommandEnum {//list all commands

    LOGIN{
        {
            setCurrentCommand(new LoginCommand());
        }
    },
    LOGOUT{
        {
            setCurrentCommand(new LogoutCommand());
        }
    },
    REGISTRATION{
        {
            setCurrentCommand(new RegistrationCommand());
        }
    },
    CREATETEST{
        {
            setCurrentCommand(new CreateTestCommand());
        }
    },
    TAKETEST{
        {
            setCurrentCommand(new TakeTestCommand());
        }
    },
    SHOWTEST{
        {
            setCurrentCommand(new ShowTestCommand());
        }
    },
    CHECKTEST{
        {
            setCurrentCommand(new CheckTestCommand());
        }
    },
    CREATE{
        {
            setCurrentCommand(new CreateCommand());
        }
    },
    CREATEQUESTION{
        {
            setCurrentCommand(new CreateQuestionCommand());
        }
    },
    CREATEALLTEST{
        {
            setCurrentCommand(new CreateAllTestCommand());
        }
    },
    FORWARDTOMAINJSP{
        {
            setCurrentCommand(new ForwardToMainJSP());
        }
    },
    CREATEUSER{
        {
            setCurrentCommand(new CreateUserCommand());
        }
    },
    CHOOSE{
        {
            setCurrentCommand(new ChooseCommand());
        }
    },
    ENTER{
        {
            setCurrentCommand(new EnterCommand());
        }
    },
    PASSFREETEST{
        {
            setCurrentCommand(new PassFreeTestCommand());
        }
    },
    FORWARDTOINDEXPAGE{
        {
            setCurrentCommand(new ForwardToIndexPage());
        }
    },
    STATISTICUSER{
        {
            setCurrentCommand(new StatisticUserCommand());
        }
    },
    CHANGETEST{
        {
            setCurrentCommand(new ChangeTestCommand());
        }
    },
    SHOWUSER{
        {
            setCurrentCommand(new ShowUserCommand());
        }
    },
    DELETETEST{
        {
            setCurrentCommand(new DeleteTestCommand());
        }
    },
    SHOWLISTQUESTIONS{
        {
            setCurrentCommand(new ShowListQuestionsCommand());
        }
    },
    DELETEQUESTION{
        {
            setCurrentCommand(new DeleteQuestionCommand());
        }
    },
    SHOWCHANGEQUESTION{
        {
            setCurrentCommand(new ShowChangeQuestionCommand());
        }
    },
    CHANGEQUESTION{
        {
            setCurrentCommand(new ChangeQuestionCommand());
        }
    },
    SAVETEST{
        {
            setCurrentCommand(new SaveTestCommand());
        }
    },
    DELETEUSER{
        {
            setCurrentCommand(new DeleteUserCommand());
        }
    },
    CHANGENAMETEST{
        {
            setCurrentCommand(new ChangeNameTestCommand());
        }
    },
    CHANGENAME{
        {
            setCurrentCommand(new ChangeNameCommand());
        }
    },
    ADDQUESTION{
        {
            setCurrentCommand(new AddQuestionCommand());
        }
    },
    ADDNEWQUESTION{
        {
            setCurrentCommand(new AddNewQuestionCommand());
        }
    };

    private IActionCommand command;
    public IActionCommand getCurrentCommand(){
        return command;
    }
    public void setCurrentCommand(IActionCommand command){
        this.command = command;
    }

}
