package source;

import java.sql.SQLException;

import dataAccessObjects.DAOFactory;
import dataAccessObjects.EventDAO;
import dataAccessObjects.TABLE;

public class Test {
	public static void main(String[] args){
		EventDAO dao = (EventDAO) DAOFactory.getDAO(TABLE.EVENT);
		try{
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
