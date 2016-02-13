package dataAccessObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCSingleton {
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private Connection conn;
	private Statement st;
	
	private static JDBCSingleton jdbcSingleton;
	
	private JDBCSingleton(){			
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection("jdbc:mysql://localhost/fit","root","");
				st = conn.createStatement();
			} catch (Exception e) {
				e.printStackTrace();
			}		
	}
	
	public static JDBCSingleton getInstance(){
		if(jdbcSingleton==null){
			jdbcSingleton=new JDBCSingleton();
		}
		return jdbcSingleton;
	}
	
	/*public Connection getConnection(){
		return this.conn;
	}*/
	
	public Statement getStatement(){
		return this.st;
	}
}
