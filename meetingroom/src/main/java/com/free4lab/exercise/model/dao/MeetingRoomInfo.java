package com.free4lab.freemonitor.model.dao;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name="MeetingRoomInfo")
public class MeetingRoomInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id",unique=true,nullable=false)
	private int id;
	
	private String name;
	private String location;
	private int capacity;
	private String open_time;
	private String close_time;
	private int projector;
	private int available;
	
	public MeetingRoomInfo()
	{}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the open_time
	 */
	public String getOpen_time() {
		return open_time;
	}

	/**
	 * @param open_time the open_time to set
	 */
	public void setOpen_time(String open_time) {
		this.open_time = open_time;
	}

	/**
	 * @return the close_time
	 */
	public String getClose_time() {
		return close_time;
	}

	/**
	 * @param close_time the close_time to set
	 */
	public void setClose_time(String close_time) {
		this.close_time = close_time;
	}

	/**
	 * @return the projector
	 */
	public int getProjector() {
		return projector;
	}

	/**
	 * @param projector the projector to set
	 */
	public void setProjector(int projector) {
		this.projector = projector;
	}

	/**
	 * @return the available
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(int available) {
		this.available = available;
	}
	
	

}