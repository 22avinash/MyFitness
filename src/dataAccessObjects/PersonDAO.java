package dataAccessObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dataTransferObject.Person;
import javafx.util.Pair;

public class PersonDAO implements DAO {
	Statement st;
	PersonDAO(){
		JDBCSingleton jdbcSingleton = JDBCSingleton.getInstance();
		this.st = jdbcSingleton.getStatement();
	}
	static ArrayList<Pair<String,String>> allPersonNames;
	public ArrayList<Pair<String,String>> getAllPersons() throws SQLException{
		if(allPersonNames!=null) return allPersonNames; // optimizing
		ArrayList<Pair<String,String>> result = new ArrayList<Pair<String,String>>();
		String sql = "select fname,lname from person";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			result.add(new Pair(rs.getString("fname"),rs.getString("lname")));
		}
		allPersonNames = result; //saving for future uses
		return result; 
	}
	public void insert(Person person) throws SQLException {
		
		String username = person.getUser_id();
		String password = person.getPassword();
		String fname = person.getFname();
		String lname = person.getLname();
		String email = person.getEmail();
		long contact = person.getContact();
		String sql = "insert into person values('"+username+"','"+password+"','"+fname+"','"+lname+"','"+email+"',"+contact+")";
		st.executeUpdate(sql);
	}

	public void update(Person person) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void delete(String user_id) throws SQLException {
		st.execute("delete from person where user_id ='"+user_id+"'");
		
	}

	public Person getPersonById(String user_id) throws SQLException {
		Person person = new Person();
		String sql = "select * from person where user_id='"+user_id+"'";
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()){
			person.setUser_id(user_id);
			person.setFname(rs.getString("fname"));
			person.setLname(rs.getString("lname"));
			person.setEmail(rs.getString("email"));
			person.setContact(rs.getLong("contact"));
			person.setPassword(rs.getString("password"));
			return person;
		}
		return null;
	}

}
