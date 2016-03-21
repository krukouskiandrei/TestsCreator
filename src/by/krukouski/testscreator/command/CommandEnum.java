package by.krukouski.testscreator.command;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public enum  CommandEnum {//list all commands

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
    },
    CHOOSE{
        {
            this.command = new ChooseCommand();
        }
    },
    ENTER{
        {
            this.command = new EnterCommand();
        }
    },
    PASSFREETEST{
        {
            this.command = new PassFreeTestCommand();
        }
    },
    FORWARDTOINDEXPAGE{
        {
            this.command = new ForwardToIndexPage();
        }
    },
    STATISTICUSER{
        {
            this.command = new StatisticUserCommand();
        }
    },
    CHANGETEST{
        {
            this.command = new ChangeTestCommand();
        }
    },
    SHOWUSER{
        {
            this.command = new ShowUserCommand();
        }
    },
    DELETETEST{
        {
            this.command = new DeleteTestCommand();
        }
    },
    SHOWLISTQUESTIONS{
        {
            this.command = new ShowListQuestionsCommand();
        }
    },
    DELETEQUESTION{
        {
            this.command = new DeleteQuestionCommand();
        }
    },
    SHOWCHANGEQUESTION{
        {
            this.command = new ShowChangeQuestionCommand();
        }
    },
    CHANGEQUESTION{
        {
            this.command = new ChangeQuestionCommand();
        }
    },
    SAVETEST{
        {
            this.command = new SaveTestCommand();
        }
    },
    DELETEUSER{
        {
            this.command = new DeleteUserCommand();
        }
    },
    CHANGENAMETEST{
        {
            this.command = new ChangeNameTestCommand();
        }
    },
    CHANGENAME{
        {
            this.command = new ChangeNameCommand();
        }
    },
    ADDQUESTION{
        {
            this.command = new AddQuestionCommand();
        }
    },
    ADDNEWQUESTION{
        {
            this.command = new AddNewQuestionCommand();
        }
    };

    public IActionCommand command;
    public IActionCommand getCurrentCommand(){
        return command;
    }


}
