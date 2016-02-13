package dataTransferObject;

import java.io.Serializable;

public class Location implements Serializable{
 private long location_id;
 private double latitude;
 private double longitude;
 private String description;
public long getLocation_id() {
	return location_id;
}
public void setLocation_id(long location_id) {
	this.location_id = location_id;
}
public double getLatitude() {
	return latitude;
}
public void setLatitude(double latitude) {
	this.latitude = latitude;
}
public double getLongitude() {
	return longitude;
}
public void setLongitude(double longitude) {
	this.longitude = longitude;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Location(long location_id, double latitude, double longitude, String description) {
	super();
	this.location_id = location_id;
	this.latitude = latitude;
	this.longitude = longitude;
	this.description = description;
}
public Location() {
	super();
	// TODO Auto-generated constructor stub
}
 
}
