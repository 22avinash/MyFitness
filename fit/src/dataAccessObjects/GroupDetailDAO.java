package dataAccessObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataTransferObject.Group_detail;
import dataTransferObject.Image;

public class GroupDetailDAO implements DAO{
	Statement st;
	GroupDetailDAO(){
		JDBCSingleton jdbcSingleton = JDBCSingleton.getInstance();
		this.st = jdbcSingleton.getStatement();
	}
	
	public long insert(Group_detail group) throws SQLException {
		long group_id = group.getGroup_id();
		String name = group.getGroup_name();
		String admin = group.getAdmin_user_id();
		byte[] icon = group.getGroup_ico();
		String description = group.getDescription();
		
		String sql = "insert into group_detail values('"+group_id+"','"+name+"','"+admin+"',"+icon+",'"+description+")";
		try{
			st.executeUpdate(sql);
		}
		catch(Exception e){
			//duplicate!!!  dont care...
			System.out.println("Event Exception:"+e.getMessage());
		}
		ResultSet rs = st.executeQuery("select group_id from group_detail where group_name ='"+name+"' and admin_user_id='"+admin+"' and grp_ico="+icon+" and description='"+description+"'");
		
		rs.next();
		group_id = rs.getLong("group_id");
		return group_id;
	}

	public void update(Group_detail group) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public void delete(long id) throws SQLException {
		
		st.execute("delete from group_detail where group_id ="+id+"");
		
	}

	public Group_detail getGroupById(long group_id) throws SQLException {
		Group_detail group = new Group_detail();
		String sql = "select * from group_detail where group_id="+group_id+"";
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()){
			group.setGroup_id(group_id);
			group.setAdmin_user_id(rs.getString("admin_user_id"));
			group.setGroup_name(rs.getString("group_name"));
			group.setGroup_ico(rs.getBytes("grp_ico"));
			group.setDescription(rs.getString("description"));
			
			return group;
		}
		return null;
	}

}
