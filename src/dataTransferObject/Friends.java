package dataTransferObject;

import java.io.Serializable;

public class Friends implements Serializable{
	
	
	private long friendship_id;
	public long getFriendship_id() {
		return friendship_id;
	}
	public void setFriendship_id(long friendship_id) {
		this.friendship_id = friendship_id;
	}
	public String getUser_id1() {
		return user_id1;
	}
	public void setUser_id1(String user_id1) {
		this.user_id1 = user_id1;
	}
	public String getUser_id2() {
		return user_id2;
	}
	public void setUser_id2(String user_id2) {
		this.user_id2 = user_id2;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	private String user_id1;
	private String user_id2;
	private String action;
	private int status;
	public Friends() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Friends(long friendship_id, String user_id1, String user_id2, String action, int status) {
		super();
		this.friendship_id = friendship_id;
		this.user_id1 = user_id1;
		this.user_id2 = user_id2;
		this.action = action;
		this.status = status;
		swap();
	}
	public void swap(){
		if(this.user_id1.compareTo(this.user_id2)>0){
			String temp = user_id1;
			user_id1 = user_id2;
			user_id2 = user_id1;
		}
	}
}
