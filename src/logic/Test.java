package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import dataAccessObjects.DAOFactory;
import dataAccessObjects.PersonDAO;
import dataAccessObjects.TABLE;
import dataTransferObject.Person;

public class Test {
	public static void main(String args[]){
		File file = new File("C:\\Users\\Golu\\workspcae\\MyFitness\\dummyperson1000.txt");
		try {
			Scanner s = new Scanner(file);
			String str = s.nextLine();
			JSONParser parser = new JSONParser();
			JSONArray arr = (JSONArray)parser.parse(str);
			for(int i=0;i<arr.size();i++){
				JSONObject obj = (JSONObject) arr.get(i);
				Person p = new Person();
				p.setFname(""+obj.get("fname"));
				p.setLname(""+obj.get("lname"));
				p.setEmail(""+obj.get("email"));
				p.setPassword(""+obj.get("password"));
				try{
					p.setContact(Long.parseLong(""+obj.get("contact")));
				}
				catch(Exception e){}
				p.setUser_id(""+obj.get("username"));
				
				PersonDAO dao = (PersonDAO)DAOFactory.getDAO(TABLE.PERSON);
				try {
					dao.insert(p);
				} catch (SQLException e) {
					
				}
			}
			
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	} 
}
