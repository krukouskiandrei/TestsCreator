package by.krukouski.testscreator.controller;

import by.krukouski.testscreator.command.IActionCommand;
import by.krukouski.testscreator.command.ActionFactory;
import by.krukouski.testscreator.resource.ConfigurationManager;
import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.session.SessionRequestContent;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Krukouski Andrei on 08.12.2015.
 */
@WebServlet("/maincontroller")
public class MainControllerServlet extends HttpServlet {

    static Logger logger = Logger.getLogger(MainControllerServlet.class);
    public void init() throws ServletException {//initialization log4j
        ServletConfig config = this.getServletConfig();
        String filename = config.getInitParameter("init_log4j");
        if(filename != null){
            PropertyConfigurator.configure(filename);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        try {
            processRequest(request, response);
            logger.debug("request and response sended in prossesRequest() from doGet");

        }catch (ServletException | IOException e){
            logger.error(e.getMessage());
            ConfigurationManager configurationManager = new ConfigurationManager();
            String page = configurationManager.getProperty("path.page.index");
            response.sendRedirect(request.getContextPath() + page);

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        try {
            processRequest(request, response);
            logger.debug("request and response sended in prossesRequest() from doPost");
        }catch (ServletException | IOException e){
            logger.error(e.getMessage());
            ConfigurationManager configurationManager = new ConfigurationManager();
            String page = configurationManager.getProperty("path.page.index");
            response.sendRedirect(request.getContextPath() + page);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String page = null;//page transition applications after request
        SessionRequestContent sessionRequest = new SessionRequestContent();
        sessionRequest.extractValue(request);

        //defining the command which came with jsp
        ActionFactory client = new ActionFactory();
        IActionCommand command = client.defineCommand(sessionRequest);
        //call method execute()
        page = command.execute(sessionRequest);//return the response page
        sessionRequest.insertAttribute(request);//paste attributes in request
        request.getSession().setAttribute("currentPage", page);
        if(page != null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            //call responce page on request
            dispatcher.forward(request, response);
        }else {
            //set page with message about error
            ConfigurationManager configurationManager = new ConfigurationManager();
            page = configurationManager.getProperty("path.page.index");
            MessageManager messageManager = new MessageManager();
            request.getSession().setAttribute("nullPage", messageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }


    }




}
