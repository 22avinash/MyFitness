package dataTransferObject;

import java.io.Serializable;

public class Event implements Serializable{
	public Event() {
		
	}
	private long event_id;
	private String event_name;
	private String event_date;
	public long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(long event_id) {
		this.event_id = event_id;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getEvent_date() {
		return event_date;
	}
	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}
	public Event(long event_id, String event_name, String event_date) {
		super();
		this.event_id = event_id;
		this.event_name = event_name;
		this.event_date = event_date;
	}
}
