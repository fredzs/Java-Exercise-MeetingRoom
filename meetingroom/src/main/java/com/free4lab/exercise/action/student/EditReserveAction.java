package com.free4lab.freemonitor.action.student;

import com.free4lab.freemonitor.account.BaseAction;
import com.free4lab.freemonitor.model.dao.ReserveDAO;
import java.sql.Timestamp;

public class EditReserveAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private int id;
	private int user_id;
	private String user_name;
	private String user_phone;
	private String teacher_name;
	private String teacher_phone;
	private int meeting_room;
	private String date;
	private int start_time;
	private int end_time;
	private String topic;
	private String participant;
	private Timestamp create_time;
	private int available=1;

	public String execute() {
		System.out.println("会议室："+meeting_room+"日期："+date+"开始："+start_time+"结束："+end_time);
		available = new ReserveDAO().check(meeting_room,date,start_time,end_time);
		System.out.println("available:");
		System.out.println("available:"+available);
		if (available==0)
		{
			new ReserveDAO().editReserve(id,user_id, user_name, user_phone, teacher_name, 
					teacher_phone, meeting_room, date,start_time,end_time, topic, participant);
		}
		return SUCCESS;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTeacher_phone() {
		return teacher_phone;
	}
	public void setTeacher_phone(String teacher_phone) {
		this.teacher_phone = teacher_phone;
	}
	public int getMeeting_room() {
		return meeting_room;
	}
	public void setMeeting_room(int meeting_room) {
		this.meeting_room = meeting_room;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getStart_time() {
		return start_time;
	}
	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}
	public int getEnd_time() {
		return end_time;
	}
	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getParticipant() {
		return participant;
	}
	public void setParticipant(String participant) {
		this.participant = participant;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}
}
