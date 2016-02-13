
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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//nothing
		System.out.println("wrong place");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		Person person = null;
		PersonDAO dao = (PersonDAO)DAOFactory.getDAO(TABLE.PERSON);		
		try {
			person = dao.getPersonById(uname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(person!=null&&person.getUser_id().equals(uname)){
			HttpSession session = request.getSession(true);
			session.setAttribute("uname", uname);
			JSONObject jobj = new JSONObject();
			jobj.put("status", 1);
			jobj.put("person", person.toJSONString());
			response.getWriter().println(jobj.toJSONString());
		}else{
			//out.println("not regestered");
			JSONObject jobj = new JSONObject();
			jobj.put("status", 0);
			response.getWriter().println(jobj.toJSONString());
		}
	}
}
