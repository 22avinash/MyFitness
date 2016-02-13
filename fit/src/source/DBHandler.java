package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHandler {
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private Connection conn;
	private Statement st;
	public DBHandler(){
		
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void connect(){
		try{
		conn = DriverManager.getConnection("jdbc:mysql://localhost/fit","root","");
		st = conn.createStatement();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void disconnect(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	ResultSet getDataFromTable(String table,String where) throws SQLException{
		String Query="SELECT * from "+table;
		if(!where.equals("")){
			Query+=" where "+where;
		}
		return st.executeQuery(Query);
	}
	ResultSet getDataFromTable(String table,String[] columns,String where) throws SQLException{
		String Query="SELECT "+columns[0];
		for(int i=1;i<columns.length;i++){
			Query+=","+columns[i];
		}
		Query+=" from "+table;
		if(!where.equals("")){
			Query+=" where "+where;
		}
		return st.executeQuery(Query);
	}
	int insertUser(String username,String password,String fname,String lname,String email,long contact) throws SQLException{
		int status=0;
		String sql = "insert into person values('"+username+"','"+password+"','"+fname+"','"+lname+"','"+email+"',"+contact+")";
		status=st.executeUpdate(sql);
		return status;
	}
}
