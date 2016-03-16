package by.krukouski.testscreator.command;

import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.session.SessionRequestContent;

/**
 * Created by Krukouski Andrei on 07.03.2016.
 */
public class ChooseCommand implements IActionCommand {

    private static final String PARAM_LANG = "lang";
    private static final String PARAM_CURRENT_PAGE = "currentPage";

    public String execute(SessionRequestContent request) {
        String page = null;
        String lang = request.getRequstParameters(PARAM_LANG)[0];
        request.setRequestAttributes("lang", lang);
        try {
            String currentPage = (String)request.getSessionAttributes(PARAM_CURRENT_PAGE);
            page = currentPage;
        }catch (NullPointerException e){
            page = ConfigurationManager.getProperty("path.page.index");
        }
        return page;
    }

}
