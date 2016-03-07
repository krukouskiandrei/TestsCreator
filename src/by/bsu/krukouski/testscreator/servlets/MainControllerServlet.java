package by.bsu.krukouski.testscreator.servlets;

import by.bsu.krukouski.testscreator.command.IActionCommand;
import by.bsu.krukouski.testscreator.command.factory.ActionFactory;
import by.bsu.krukouski.testscreator.exception.ResourceServletException;
import by.bsu.krukouski.testscreator.exception.ResourceIOException;
import by.bsu.krukouski.testscreator.resource.ConfigurationManager;
import by.bsu.krukouski.testscreator.resource.MessageManager;
import by.bsu.krukouski.testscreator.session.SessionRequestContent;
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
    public void init() throws ResourceServletException {//инициализация log4j
        ServletConfig config = this.getServletConfig();
        String filename = config.getInitParameter("init_log4j");
        if(filename != null){
            PropertyConfigurator.configure(filename);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response){

        try {
            processRequest(request, response);
            logger.info("request and response sended in prossesRequest() from doGet");

        }catch (ServletException e){
            new ResourceServletException(e);
            logger.error(e.getMessage());
        }catch (IOException e){
            new ResourceIOException(e);
            logger.error(e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response){

        try {
            processRequest(request, response);
            logger.info("request and response sended in prossesRequest() from doPost");
        }catch (ServletException e){
            new ResourceServletException(e);
            logger.error(e.getMessage());
        }catch (IOException e){
            new ResourceIOException(e);
            logger.error(e.getMessage());
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String page = null;//страница на которую на которую перейдет приложение после запроса
        SessionRequestContent sessionRequest = new SessionRequestContent();
        sessionRequest.extractValue(request);

        //определение команды пришедшей с jsp
        ActionFactory client = new ActionFactory();
        IActionCommand command = client.defineCommand(sessionRequest);
        //вызов метода execute() и передача параметров классу-обработчику конкрутной задачи
        page = command.execute(sessionRequest);//вернется страница ответа
        sessionRequest.insertAttribute(request);//вставка атрибутов в request
        System.out.println(request.getAttribute("errorLoginPassMessage"));
        if(page != null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            //вызов страницы ответа на запрос
            dispatcher.forward(request, response);
        }else {
            //установка страницы с сообщением об ошибке
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }


    }




}
