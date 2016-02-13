package dataTransferObject;

import java.io.Serializable;

public class Video implements Serializable{
	private long vid_id;
	private byte[] vid;
	private String description;
	public long getVid_id() {
		return vid_id;
	}
	public void setVid_id(long vid_id) {
		this.vid_id = vid_id;
	}
	public byte[] getVid() {
		return vid;
	}
	public void setVid(byte[] vid) {
		this.vid = vid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Video(long vid_id, byte[] vid, String description) {
		super();
		this.vid_id = vid_id;
		this.vid = vid;
		this.description = description;
	}
}
