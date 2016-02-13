
package source;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;


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
		PrintWriter out = response.getWriter();
		String uname=request.getParameter("uname");
		String pwd =request.getParameter("pwd");
		try{
			DBHandler dbh = new DBHandler();
			dbh.connect();
			ResultSet rs = dbh.getDataFromTable("person", "user_id='"+uname+"' and password='"+pwd+"'");
			
			int count = 0;
			if(rs.last()){
				count = rs.getRow();
				rs.beforeFirst();
			}
			rs.next();
			JSONObject jobj = new JSONObject();
			if(count==1){
				HttpSession session = request.getSession();
				session.setAttribute("user_id", rs.getString("user_id"));
				jobj.put("status",1);
				jobj.put("user_id",rs.getString("user_id"));
				jobj.put("fname",rs.getString("fname"));
				jobj.put("lname",rs.getString("lname"));
				jobj.put("email",rs.getString("email"));
				jobj.put("contact",rs.getLong("contact"));
				jobj.put("longitude",rs.getDouble("longitude"));
				jobj.put("latitude",rs.getDouble("latitude"));
			}
			else{
				jobj.put("status",0);
			}
			dbh.disconnect();
			String jstring = jobj.toJSONString();
			out.println(jstring);
		}
		catch(Exception e){
			System.err.println("Login Exception: ");
			e.printStackTrace();
		}
	}
}
