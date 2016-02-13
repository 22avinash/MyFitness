package dataAccessObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataTransferObject.Video;
import dataTransferObject.Video;

public class VideoDAO implements DAO{
	Statement st;
	VideoDAO(){
		JDBCSingleton jdbcSingleton = JDBCSingleton.getInstance();
		this.st = jdbcSingleton.getStatement();
	}
	
	public long insert(Video video) throws SQLException {
		long vid_id =0;
		byte[] vid = video.getVid();
		String description = video.getDescription();
		String sql = "insert into video values("+vid_id+",'"+vid+"','"+description+"')";
		try{
			st.executeUpdate(sql);
		}
		catch(Exception e){
			//duplicate!!!  dont care...
			System.out.println("Event Exception:"+e.getMessage());
		}
		ResultSet rs = st.executeQuery("select vid_id from video where vid ='"+vid+"' and description='"+description+"'");
		rs.next();
		vid_id = rs.getLong("vid_id");
		return vid_id;
	}

	public void update(Video vid) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public void delete(long id) throws SQLException {
		
		st.execute("delete from video where vid_id ="+id+"");
		
	}

	public Video getVideoById(long vid_id) throws SQLException {
		Video Video = new Video();
		String sql = "select * from video where vid_id="+vid_id+"";
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()){
			Video.setVid_id(rs.getLong("vid_id"));
			Video.setVid(rs.getBytes("vid"));
			Video.setDescription(rs.getString("description"));
			return Video;
		}
		return null;
	}

}