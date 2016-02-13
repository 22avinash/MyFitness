package logic;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import dataAccessObjects.DAOFactory;
import dataAccessObjects.PersonDAO;
import dataAccessObjects.TABLE;
import dataTransferObject.Person;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("uname");
		String password=request.getParameter("pwd");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		long contact=Long.parseLong(request.getParameter("contact"));
		//double latitude = Double.parseDouble(request.getParameter("latitude"));
		//double longitude = Double.parseDouble(request.getParameter("longitude"));
		try {
			PersonDAO dao = (PersonDAO)DAOFactory.getDAO(TABLE.PERSON);
			if(dao.getPersonById(username)==null){
				Person person = new Person(username,fname,lname,email,contact,password);
				dao.insert(person);
				HttpSession session = request.getSession(true);
				session.setAttribute("uname", username);
				JSONObject jobj = new JSONObject();
				jobj.put("status", 1);
				jobj.put("person", person.toJSONString());
				response.getWriter().println(jobj.toJSONString());
			}
			else{
				JSONObject jobj = new JSONObject();
				jobj.put("status", 0); // user already found in the database
				response.getWriter().println(jobj.toJSONString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
