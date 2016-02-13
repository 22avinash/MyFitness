package dataAccessObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataTransferObject.Friends;
import dataTransferObject.Video;

public class FriendsDAO implements DAO {
	Statement st;
		FriendsDAO(){
			JDBCSingleton jdbcSingleton = JDBCSingleton.getInstance();
			this.st = jdbcSingleton.getStatement();
		}
		
		public void insert(Friends f) throws SQLException {
			f.swap();
			String user1 = f.getUser_id1();
			String user2 = f.getUser_id2();
			int status = f.getStatus();
			String action = f.getAction();
			String sql = "insert into friends values('"+user1+"','"+user2+"',"+status+",'"+action+"')";
			try{
				st.executeUpdate(sql);
			}
			catch(Exception e){
				//duplicate!!!  dont care...
				System.out.println("Event Exception:"+e.getMessage());
			}
		}

		public void update(Friends f) throws SQLException {
			f.swap();
			// TODO Auto-generated method stub
			
		}
		public void delete(long fid) throws SQLException {
			
			st.execute("delete from friends where friendship_id="+fid);
			
		}

		public Friends getFriendsById(long fid) throws SQLException {
			Friends f = new Friends();
			String sql = "select * from friends where friendship_id="+fid+"";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				f.setFriendship_id(rs.getLong("friendship_id"));
				f.setAction(rs.getString("action"));
				f.setStatus(rs.getInt("status"));
				f.setUser_id1(rs.getString("user_id1"));
				f.setUser_id2(rs.getString("user_id2"));
				return f;
			}
			return null;
		}

	}
