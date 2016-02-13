package dataAccessObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataTransferObject.Event;
import dataTransferObject.Image;

public class ImageDAO implements DAO {
	Statement st;
	ImageDAO(){
		JDBCSingleton jdbcSingleton = JDBCSingleton.getInstance();
		this.st = jdbcSingleton.getStatement();
	}
	
	public long insert(Image image) throws SQLException {
		long img_id =0;
		byte[] img = image.getImg();
		String description = image.getDescription();
		String sql = "insert into image values("+img_id+",'"+img+"','"+description+"')";
		try{
			st.executeUpdate(sql);
		}
		catch(Exception e){
			//duplicate!!!  dont care...
			System.out.println("Event Exception:"+e.getMessage());
		}
		ResultSet rs = st.executeQuery("select img_id from image where img ='"+img+"' and description='"+description+"'");
		rs.next();
		img_id = rs.getLong("img_id");
		return img_id;
	}

	public void update(Image img) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public void delete(long id) throws SQLException {
		
		st.execute("delete from image where img_id ="+id+"");
		
	}

	public Image getImageById(long img_id) throws SQLException {
		Image image = new Image();
		String sql = "select * from image where img_id="+img_id+"";
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()){
			image.setImg_id(rs.getLong("img_id"));
			image.setImg(rs.getBytes("img"));
			image.setDescription(rs.getString("description"));
			return image;
		}
		return null;
	}

}
