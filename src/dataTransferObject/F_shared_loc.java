package dataTransferObject;

import java.io.Serializable;

public class F_shared_loc implements Serializable{
	private long friendship_id;
	private long location_id;
	public long getFriendship_id() {
		return friendship_id;
	}
	public void setFriendship_id(long friendship_id) {
		this.friendship_id = friendship_id;
	}
	public long getLocation_id() {
		return location_id;
	}
	public void setLocation_id(long location_id) {
		this.location_id = location_id;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getShared_date() {
		return shared_date;
	}
	public void setShared_date(String shared_date) {
		this.shared_date = shared_date;
	}
	private String caption;
	public F_shared_loc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public F_shared_loc(long friendship_id, long location_id, String caption, String shared_date) {
		super();
		this.friendship_id = friendship_id;
		this.location_id = location_id;
		this.caption = caption;
		this.shared_date = shared_date;
	}
	private String shared_date;
}
