package dataTransferObject;

import java.io.Serializable;

public class F_shared_img implements Serializable{
	public long getFriendship_id() {
		return friendship_id;
	}
	public void setFriendship_id(long friendship_id) {
		this.friendship_id = friendship_id;
	}
	public long getImg_id() {
		return img_id;
	}
	public void setImg_id(long img_id) {
		this.img_id = img_id;
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
	private long friendship_id;
	private long img_id;
	private String caption;
	private String shared_date;
	public F_shared_img(long friendship_id, long img_id, String caption, String shared_date) {
		super();
		this.friendship_id = friendship_id;
		this.img_id = img_id;
		this.caption = caption;
		this.shared_date = shared_date;
	}
	public F_shared_img() {
	
		// TODO Auto-generated constructor stub
	}
}
