package dataTransferObject;

import java.io.Serializable;

public class Image implements Serializable{
	private long img_id;
	private byte[] img;
	private String description;
	public long getImg_id() {
		return img_id;
	}
	public void setImg_id(long img_id) {
		this.img_id = img_id;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Image(long img_id, byte[] img, String description) {
		super();
		this.img_id = img_id;
		this.img = img;
		this.description = description;
	}
}
