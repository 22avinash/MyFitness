package dataAccessObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataTransferObject.Event;
import dataTransferObject.Person;

public class EventDAO implements DAO {
	Statement st;
	EventDAO(){
		JDBCSingleton jdbcSingleton = JDBCSingleton.getInstance();
		this.st = jdbcSingleton.getStatement();
	}
	
	public long insert(Event event) throws SQLException {
		long event_id =0;
		String event_name = event.getEvent_name();
		String event_date = event.getEvent_date();
		String sql = "insert into event values("+event_id+",'"+event_name+"','"+event_date+"')";
		try{
			st.executeUpdate(sql);
		}
		catch(Exception e){
			//duplicate!!!  dont care...
			System.out.println("Event Exception:"+e.getMessage());
		}
		ResultSet rs = st.executeQuery("select event_id from event where event_name='"+event_name+"' and event_date='"+event_date+"'");
		rs.next();
		event_id = rs.getLong("event_id");
		return event_id;
	}

	public void update(Event event) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public void delete(long id) throws SQLException {
		
		st.execute("delete from event where event_id ="+id+"");
		
	}

	public Event getEventById(long event_id) throws SQLException {
		Event event = new Event();
		String sql = "select * from event where event_id="+event_id+"";
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()){
			event.setEvent_id(event_id);
			event.setEvent_name(rs.getString("event_name"));
			event.setEvent_date(rs.getString("event_date"));
			return event;
		}
		return null;
	}

}
