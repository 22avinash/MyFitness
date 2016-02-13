package dataTransferObject;

import java.io.Serializable;

public class MyGroup implements Serializable{
	private long mg_id;
	private String user_id;
	private long group_id;
	public long getMg_id() {
		return mg_id;
	}
	public void setMg_id(long mg_id) {
		this.mg_id = mg_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public long getGroup_id() {
		return group_id;
	}
	public void setGroup_id(long group_id) {
		this.group_id = group_id;
	}
	public MyGroup(long mg_id, String user_id, long group_id) {
		super();
		this.mg_id = mg_id;
		this.user_id = user_id;
		this.group_id = group_id;
	}
	public MyGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
