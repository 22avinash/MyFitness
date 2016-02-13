package logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dataAccessObjects.DAOFactory;
import dataAccessObjects.PersonDAO;
import dataAccessObjects.TABLE;
import javafx.util.Pair;

/**
 * Servlet implementation class SearchPerson
 */
@WebServlet("/SearchPerson")
public class SearchPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchPerson() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//status 0-not authorized, 1-success, 2-no query found
		HttpSession session = request.getSession(false);
		if(session==null){
			//status 0
			response.getWriter().println("Please login ");
		}
		else{
			String query = request.getParameter("q");
			if(!query.equals("")){
				query = query.toLowerCase();
				//status 1
				// do some mining with session.getAttribute("uname"); to suggest person
				PersonDAO dao = (PersonDAO)DAOFactory.getDAO(TABLE.PERSON);
				ArrayList<Pair<String,String>> persons=null;
				try {
					persons = dao.getAllPersons();
				} catch (SQLException e) {
					System.out.println("Exception: "+e.getMessage());
				}
				if(persons!=null){
				JSONArray array = new JSONArray();
				for(Pair<String,String> p:persons)
					if(p.getKey().toLowerCase().startsWith(query)||p.getValue().toLowerCase().startsWith(query))
					{
						JSONObject obj= new JSONObject();
						obj.put("fname",p.getKey());
						obj.put("lname",p.getValue());
						array.add(obj);
					}
					response.getWriter().println(array.toJSONString());
				}
				else
					response.getWriter().println("Nothing found in db");
			}
			else{
				//status 2
				response.getWriter().println("please enter a query");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

}
