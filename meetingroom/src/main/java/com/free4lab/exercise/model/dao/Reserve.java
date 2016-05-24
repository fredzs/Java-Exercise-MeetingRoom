package com.free4lab.freemonitor.model.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * The persistent class for the meetingroom database table.
 * 
 */
@Entity
@Table(name="Reserve")
public class Reserve implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private int user_id;

	@Column(length=255)
	private String user_name;

	@Column(length=255)
	private String user_phone;

	@Column(length=255)
	private String teacher_name;
	
	@Column(length=255)
	private String teacher_phone;

	@Column(nullable=false)
	private int meeting_room;
	
	@Column(nullable=true)
	private String date;
	
	@Column(nullable = false)
	private int start_time;
	
	@Column(nullable = false)
	private int end_time;

	@Column(length=255)
	private String topic;
	
	@Column(length=255)
	private String participant;

	@Column(length=255)
	private Timestamp create_time;



	public Reserve(int id,int user_id, String user_name, String user_phone,String teacher_name, String teacher_phone, 
			int meeting_room,String date, int start_time, int end_time,String topic, 
			String participant, Timestamp create_time) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.teacher_name = teacher_name;
		this.teacher_phone = teacher_phone;
		this.meeting_room = meeting_room;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.topic = topic;
		this.participant = participant;
		this.create_time = create_time;
	}
	
	public Reserve(int user_id, String user_name, String user_phone,String teacher_name, String teacher_phone, 
			int meeting_room,String date, int start_time, int end_time,String topic, 
			String participant, Timestamp create_time) {
		// TODO Auto-generated constructor stub
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.teacher_name = teacher_name;
		this.teacher_phone = teacher_phone;
		this.meeting_room = meeting_room;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.topic = topic;
		this.participant = participant;
		this.create_time = create_time;
	}

	public Reserve(){
	}
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
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return the user_phone
	 */
	public String getUser_phone() {
		return user_phone;
	}

	/**
	 * @param user_phone the user_phone to set
	 */
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	/**
	 * @return the teacher_name
	 */
	public String getTeacher_name() {
		return teacher_name;
	}

	/**
	 * @param teacher_name the teacher_name to set
	 */
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	/**
	 * @return the teacher_phone
	 */
	public String getTeacher_phone() {
		return teacher_phone;
	}

	/**
	 * @param teacher_phone the teacher_phone to set
	 */
	public void setTeacher_phone(String teacher_phone) {
		this.teacher_phone = teacher_phone;
	}

	/**
	 * @return the meeting_room
	 */
	public int getMeeting_room() {
		return meeting_room;
	}

	/**
	 * @param meeting_room the meeting_room to set
	 */
	public void setMeeting_room(int meeting_room) {
		this.meeting_room = meeting_room;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the start_time
	 */
	public int getStart_time() {
		return start_time;
	}
	/**
	 * @param start_time the start_time to set
	 */
	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}

	/**
	 * @return the end_time
	 */
	public int getEnd_time() {
		return end_time;
	}

	/**
	 * @param end_time the end_time to set
	 */
	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}

	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}

	/**
	 * @return the participant
	 */
	public String getParticipant() {
		return participant;
	}

	/**
	 * @param participant the participant to set
	 */
	public void setParticipant(String participant) {
		this.participant = participant;
	}

	/**
	 * @return the create_time
	 */
	public Timestamp getCreate_time() {
		return create_time;
	}

	/**
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
    
    }

