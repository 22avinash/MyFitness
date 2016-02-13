package dataAccessObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataTransferObject.MyGroup;

public class MyGroupDAO implements DAO {
	Statement st;
	MyGroupDAO(){
		st = JDBCSingleton.getInstance().getStatement();
	}
	
	public long insert(MyGroup my_group) throws SQLException{
		long id = my_group.getMg_id();
		long group_id = my_group.getGroup_id();
		String user_id = my_group.getUser_id();
		String sql = "insert into my_group values("+id+",'"+user_id+"',"+group_id+")";
		if(st.executeUpdate(sql)>0){
			sql = "select mg_id from my_group where user_id='"+user_id+"',group_id"+group_id;
			ResultSet rs = st.executeQuery(sql);
			id = rs.getLong("mg_id");
		}
		return id;
	}
	public void update(MyGroup my_group)throws SQLException{
		
	}
	public void delete(long id) throws SQLException{
		st.execute("delete from my_group where mg_id="+id);
	}
}
