package dataAccessObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataTransferObject.Image;
import dataTransferObject.Location;

public class LocationDAO implements DAO{
	Statement st;
	LocationDAO(){
		JDBCSingleton jdbcSingleton = JDBCSingleton.getInstance();
		this.st = jdbcSingleton.getStatement();
	}
	
	public long insert(Location loc) throws SQLException {
		long loc_id =loc.getLocation_id();
		double latitude = loc.getLatitude();
		double longitude = loc.getLongitude();
		String desc = loc.getDescription();
		String sql = "insert into location values("+loc_id+","+latitude+","+longitude+",'"+desc+"')";
		try{
			st.executeUpdate(sql);
		}
		catch(Exception e){
			//duplicate!!!  dont care...
			System.out.println("Event Exception:"+e.getMessage());
		}
		ResultSet rs = st.executeQuery("select location_id from location where latitude ="+latitude+" and longitude="+longitude+"");
		rs.next();
		loc_id = rs.getLong("location_id");
		return loc_id;
	}

	public void update(Image img) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public void delete(long id) throws SQLException {
		
		st.execute("delete from location where location_id ="+id+"");
		
	}

	public Location getLocationById(long loc_id) throws SQLException {
		Location loc = new Location();
		String sql = "select * from location where location_id="+loc_id+"";
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()){
			loc.setLatitude(rs.getDouble("latitude"));
			loc.setLongitude(rs.getDouble("longitude"));
			loc.setDescription(rs.getString("description"));
			return loc;
		}
		return null;
	}

}
