package dataTransferObject;

import java.io.Serializable;

public class G_shared_event implements Serializable{
	private long mg_id;
	private long event_id;
	private String caption;
	private String shared_date;
	public G_shared_event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public G_shared_event(long mg_id, long event_id, String caption, String shared_date) {
		super();
		this.mg_id = mg_id;
		this.event_id = event_id;
		this.caption = caption;
		this.shared_date = shared_date;
	}
	public long getMg_id() {
		return mg_id;
	}
	public void setMg_id(long mg_id) {
		this.mg_id = mg_id;
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
}
