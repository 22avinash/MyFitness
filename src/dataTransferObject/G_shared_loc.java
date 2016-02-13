package dataTransferObject;

import java.io.Serializable;

public class G_shared_loc implements Serializable{
	private long friendship_id;
	private long event_id;
	private String caption;
	private String shared_date;
	public long getFriendship_id() {
		return friendship_id;
	}
	public void setFriendship_id(long friendship_id) {
		this.friendship_id = friendship_id;
	}
	public long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(long event_id) {
		this.event_id = event_id;
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
	public G_shared_loc(long friendship_id, long event_id, String caption, String shared_date) {
		super();
		this.friendship_id = friendship_id;
		this.event_id = event_id;
		this.caption = caption;
		this.shared_date = shared_date;
	}
	public G_shared_loc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
