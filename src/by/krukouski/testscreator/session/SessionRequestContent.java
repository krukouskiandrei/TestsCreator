package by.krukouski.testscreator.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Krukouski Andrei on 09.12.2015.
 */
public class SessionRequestContent  {//class to store the contents of the request

    private HashMap<String, Object> requestAttributes;//storage attributes
    private HashMap<String, String[]> requestParameters;//storage parameters
    private HashMap<String, Object> sessionAttribytes; // starage session attribytes

    public SessionRequestContent(){
        requestAttributes = new HashMap<String, Object>();
        requestParameters = new HashMap<String, String[]>();
        sessionAttribytes = new HashMap<String, Object>();
    }

    //extract information from request
    public void extractValue(HttpServletRequest request){

        Enumeration parameters = request.getParameterNames();
        while(parameters.hasMoreElements()){
            String parameter = parameters.nextElement().toString();
            requestParameters.put(parameter, request.getParameterValues(parameter));
        }

        Enumeration atributes = request.getAttributeNames();
        while (atributes.hasMoreElements()){
            String atribute = atributes.nextElement().toString();
            requestAttributes.put(atribute, request.getAttribute(atribute));
        }

        HttpSession session = request.getSession(true);
        Enumeration atributesSession = session.getAttributeNames();
        while (atributesSession.hasMoreElements()){
            String atributeSession = atributesSession.nextElement().toString();
            sessionAttribytes.put(atributeSession, session.getAttribute(atributeSession));
        }

    }

    //add information in request
    public void insertAttribute(HttpServletRequest request){

        HttpSession session = request.getSession(true);
        Set<Map.Entry<String, Object>> setAttributes = requestAttributes.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = setAttributes.iterator();
        while (iterator.hasNext()){

            Map.Entry<String, Object> me = iterator.next();
            request.setAttribute(me.getKey(), me.getValue());
            session.setAttribute(me.getKey(), me.getValue());

        }

    }

    public  void insertAttributeSession(HttpSession session){//add information in session

        Set<Map.Entry<String, Object>> setAttributesSession = sessionAttribytes.entrySet();
        Iterator<Map.Entry<String, Object>> iter = setAttributesSession.iterator();
        while (iter.hasNext()){

            Map.Entry<String, Object> me = iter.next();
            session.setAttribute(me.getKey(), me.getValue());

        }

    }


    public void setRequestAttributes(String string, Object object){//set attribute

        requestAttributes.put(string, object);

    }

    public void setRequestParameters(String string, String[] strings){//set parameters

        requestParameters.put(string, strings);

    }

    public void setSessionAttribytes(String string, Object object){//set attribute in session

        sessionAttribytes.put(string, object);

    }

    public Object getRequestAttributes(String string){//get attribute from request

        return requestAttributes.get(string);

    }

    public String[] getRequstParameters(String string){//get parameter from request

        return requestParameters.get(string);

    }

    public Object getSessionAttributes(String string){//get attribute from session

        return sessionAttribytes.get(string);

    }



    //redirect  toString method
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Request Parameters: " + requestParameters.toString());
        result.append("Request Attributes: " + requestAttributes.toString());
        return result.toString();
    }

}
