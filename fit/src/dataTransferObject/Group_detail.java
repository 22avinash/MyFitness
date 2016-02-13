package dataTransferObject;

import java.io.Serializable;

public class Group_detail implements Serializable{
	private long group_id;
	private String group_name;
	private String admin_user_id;
	private byte[] group_ico;
	private String description;
	public Group_detail(long group_id, String group_name, String admin_user_id, byte[] group_ico, String description) {
		super();
		this.group_id = group_id;
		this.group_name = group_name;
		this.admin_user_id = admin_user_id;
		this.group_ico = group_ico;
		this.description = description;
	}
	public Group_detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getGroup_id() {
		return group_id;
	}
	public void setGroup_id(long group_id) {
		this.group_id = group_id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getAdmin_user_id() {
		return admin_user_id;
	}
	public void setAdmin_user_id(String admin_user_id) {
		this.admin_user_id = admin_user_id;
	}
	public byte[] getGroup_ico() {
		return group_ico;
	}
	public void setGroup_ico(byte[] group_ico) {
		this.group_ico = group_ico;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
