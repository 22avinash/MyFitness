package source;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

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
		
		PrintWriter out = response.getWriter();
		DBHandler dbh = new DBHandler();
		dbh.connect();
		try {
			ResultSet rs = dbh.getDataFromTable("person", "user_id = '"+username+"'");
			int count = 0;
			if(rs.last()){
				count = rs.getRow();
				rs.beforeFirst();
			}
			JSONObject jobj = new JSONObject();
			if(count==0){
				if(dbh.insertUser(username, password, fname, lname, email, contact)==1){
					jobj.put("status", 1);
					HttpSession session= request.getSession();
					session.setAttribute("user_id", username);
				}
				else{
					jobj.put("status", 0);
					jobj.put("error", "SQL Error");
				}
			}
			else{
				jobj.put("status", 0);
				jobj.put("error", "User already exist");
			}
			out.println(jobj.toJSONString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
