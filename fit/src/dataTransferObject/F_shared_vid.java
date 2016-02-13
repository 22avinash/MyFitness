package dataTransferObject;

import java.io.Serializable;

public class F_shared_vid implements Serializable{
	private long friendship_id;
	private long vid_id;
	private String caption;
	private String shared_date;
	public long getFriendship_id() {
		return friendship_id;
	}
	public void setFriendship_id(long friendship_id) {
		this.friendship_id = friendship_id;
	}
	public long getVid_id() {
		return vid_id;
	}
	public void setVid_id(long vid_id) {
		this.vid_id = vid_id;
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
	public F_shared_vid(long friendship_id, long vid_id, String caption, String shared_date) {
		super();
		this.friendship_id = friendship_id;
		this.vid_id = vid_id;
		this.caption = caption;
		this.shared_date = shared_date;
	}
	public F_shared_vid() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
